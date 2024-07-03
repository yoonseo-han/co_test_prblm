//https://www.acmicpc.net/problem/15683
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let getSize = input[0].split(" ").map(a => parseInt(a));
let height = getSize[0];
let width = getSize[1];
let dx = [1, 0, -1, 0];
let dy = [0, -1, 0, 1];

let map = [];

function getSizeLand(curMap) {
    let count = 0;
    for (let i = 0; i < height; i++) {
        for (let j = 0; j < width; j++) {
            if (curMap[i][j] === 0) count++;
        }
    }
    return count;
}

for (let i = 0; i < height; i++) {
    let curRow = input[i + 1].split(" ").map(a => parseInt(a));
    map.push(curRow);
}

function CCTVProject(direction, startY, startX, curMap) {
    let curX = startX + dx[direction];
    let curY = startY + dy[direction];
    while (true) {
        if (curY < 0 || curX < 0 || curY >= height || curX >= width || curMap[curY][curX] === 6) break;
        if (curMap[curY][curX] === 0) curMap[curY][curX] = '*';
        curX = curX + dx[direction];
        curY = curY + dy[direction];
    }
}

function callRespectiveCCTV(type, ver, startY, startX, curMap) {
    switch (type) {
        case 1:
            CCTVProject(ver, startY, startX, curMap);
            break;
        case 2:
            if (ver === 0 || ver === 2) {
                CCTVProject(0, startY, startX, curMap);
                CCTVProject(2, startY, startX, curMap);
            } else {
                CCTVProject(1, startY, startX, curMap);
                CCTVProject(3, startY, startX, curMap);
            }
            break;
        case 3:
            if (ver === 0) {
                CCTVProject(0, startY, startX, curMap);
                CCTVProject(3, startY, startX, curMap);
            } else if (ver === 1) {
                CCTVProject(0, startY, startX, curMap);
                CCTVProject(1, startY, startX, curMap);
            } else if (ver === 2) {
                CCTVProject(2, startY, startX, curMap);
                CCTVProject(1, startY, startX, curMap);
            } else {
                CCTVProject(3, startY, startX, curMap);
                CCTVProject(2, startY, startX, curMap);
            }
            break;
        case 4:
            if (ver === 0) {
                CCTVProject(0, startY, startX, curMap);
                CCTVProject(3, startY, startX, curMap);
                CCTVProject(2, startY, startX, curMap);
            } else if (ver === 1) {
                CCTVProject(0, startY, startX, curMap);
                CCTVProject(1, startY, startX, curMap);
                CCTVProject(3, startY, startX, curMap);
            } else if (ver === 2) {
                CCTVProject(2, startY, startX, curMap);
                CCTVProject(1, startY, startX, curMap);
                CCTVProject(0, startY, startX, curMap);
            } else {
                CCTVProject(3, startY, startX, curMap);
                CCTVProject(2, startY, startX, curMap);
                CCTVProject(1, startY, startX, curMap);
            }
            break;
        case 5:
            CCTVProject(0, startY, startX, curMap);
            CCTVProject(1, startY, startX, curMap);
            CCTVProject(3, startY, startX, curMap);
            CCTVProject(2, startY, startX, curMap);
            break;
    }
}

function generateCombination(storeComb, curComb, n) {
    if (curComb.length === n) {
        storeComb.push([...curComb]); // Use spread operator to make a copy
        return; // Add return statement to stop further recursion
    }

    for (let i = 0; i < 4; i++) {
        curComb.push(i);
        generateCombination(storeComb, curComb, n);
        curComb.pop(); // Remove the last element to backtrack
    }
}

let CCTV = [];
// Traverse 2D array and store position index of CCTV
for (let i = 0; i < height; i++) {
    for (let j = 0; j < width; j++) {
        if (map[i][j] >= 1 && map[i][j] <= 5) {
            CCTV.push([i, j, map[i][j]]);
        }
    }
}

let storeComb = [];
generateCombination(storeComb, [], CCTV.length);
let min = width * height;
for (curComb of storeComb) {
    let newMap = map.map(arr => arr.slice());
    for (let i = 0; i < CCTV.length; i++) {
        callRespectiveCCTV(CCTV[i][2], curComb[i], CCTV[i][0], CCTV[i][1], newMap);
    }
    min = Math.min(getSizeLand(newMap), min);
}
console.log(min);
