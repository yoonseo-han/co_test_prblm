const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let [N, M] = input[0].split(" ").map(a => parseInt(a));
let storeHouse = [];
let storeLocation = [];

let mapStore = input.slice(1).map(a => a.split(" ").map(Number));
let answer = Infinity;

function getDistanceSum(houseLocation, storeLocation) {
    let sum = 0;
    for (let [hx, hy] of houseLocation) {
        let minDistance = Infinity;
        for (let [sx, sy] of storeLocation) {
            minDistance = Math.min(minDistance, Math.abs(hx - sx) + Math.abs(hy - sy));
        }
        sum += minDistance;
    }
    return sum;
}

function generateCombination(M, houseLocation, storeLocation, curStoreLocation, curInd) {
    if (curStoreLocation.length === M) {
        answer = Math.min(answer, getDistanceSum(houseLocation, curStoreLocation));
        return;
    }
    for (let i = curInd; i < storeLocation.length; i++) {
        curStoreLocation.push(storeLocation[i]);
        generateCombination(M, houseLocation, storeLocation, curStoreLocation, i + 1);
        curStoreLocation.pop();
    }
}

for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (mapStore[i][j] === 1) storeHouse.push([i, j]);
        if (mapStore[i][j] === 2) storeLocation.push([i, j]);
    }
}

let curStoreLocation = [];
generateCombination(M, storeHouse, storeLocation, curStoreLocation, 0);
console.log(answer);
