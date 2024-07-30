const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const height = parseInt(input[0].split(" ")[0]);
const width = parseInt(input[0].split(" ")[1]);

let map = input.slice(1).map(line => line.split(" ").map(Number));

const directions = [
    [0, 1],   // right
    [1, 0],   // down
    [0, -1],  // left
    [-1, 0]   // up
];

function printMap(map) {
    let curString = '';
    map.forEach(curRow => curString += curRow.join(" ") + '\n');
    console.log(curString);
}

function getSafeZoneSize(map) {
    let safeZone = 0;
    map.forEach(curRow => curRow.forEach(curElement => safeZone += (curElement === 0) ? 1 : 0));
    return safeZone;
}

function extractCoord(map) {
    let storeCoord = [];
    for (let i = 0; i < map.length; i++) {
        for (let j = 0; j < map[0].length; j++) {
            if (map[i][j] === 0) storeCoord.push([i, j]);
        }
    }
    return storeCoord;
}

function extractVirusCoord(map) {
    let storeCoord = [];
    for (let i = 0; i < map.length; i++) {
        for (let j = 0; j < map[0].length; j++) {
            if (map[i][j] === 2) storeCoord.push([i, j]);
        }
    }
    return storeCoord;
}

function generateCombination(availableCoord, combinationLength) {
    const storeCoord = []; // Store all valid combinations

    function backtracking(curArr, startIndex) {
        if (curArr.length === combinationLength) {
            storeCoord.push([...curArr]); // Use spread to create a copy
            return;
        }

        for (let i = startIndex; i < availableCoord.length; i++) {
            curArr.push(availableCoord[i]);
            backtracking(curArr, i + 1); // Move to the next index
            curArr.pop(); 
        }
    }

    backtracking([], 0); 
    return storeCoord;
}

function spreadVirus(map, visited, start) {
    const queue = [start];

    while (queue.length > 0) {
        const [curY, curX] = queue.shift();

        if (visited[curY][curX]) continue;

        visited[curY][curX] = true;
        map[curY][curX] = 2;

        for (const [dx, dy] of directions) {
            const newX = curX + dx;
            const newY = curY + dy;

            if (newX >= 0 && newX < width && newY >= 0 && newY < height && !visited[newY][newX] && map[newY][newX] === 0) {
                queue.push([newY, newX]);
            }
        }
    }
}

function paintMap(map, wallLocation) {
    wallLocation.forEach(([curY, curX]) => {
        if (curX >= 0 && curX < map[0].length && curY >= 0 && curY < map.length) {
            map[curY][curX] = 1; 
        }
    });
}

let availableCoord = extractCoord(map);
let virusCoord = extractVirusCoord(map);
let coordCombination = generateCombination(availableCoord, 3); // Specify combination length
let maxSafeZone = 0;

for (let i = 0; i < coordCombination.length; i++) {
    let tempMap = map.map(row => row.slice());
    let visited = Array.from({ length: height }, () => Array(width).fill(false)); 
    
    paintMap(tempMap, coordCombination[i]);
    
    virusCoord.forEach(([curY, curX]) => {
        spreadVirus(tempMap, visited, [curY, curX]);
    });
    
    maxSafeZone = Math.max(maxSafeZone, getSafeZoneSize(tempMap)); // Fix argument
}

console.log(maxSafeZone);
