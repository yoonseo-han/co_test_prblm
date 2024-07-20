//https://www.acmicpc.net/problem/2468
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let N = parseInt(input[0]);
let dx = [-1, 1, 0, 0];
let dy = [0, 0, 1, -1];
let count = 0;

function countIsland(mapStore, visited, x, y, height) {
    visited[x][y] = true;

    for (let dir = 0; dir < 4; dir++) {
        let newX = x + dx[dir];
        let newY = y + dy[dir];

        if (newX < 0 || newY < 0 || newX >= N || newY >= N || visited[newX][newY] || mapStore[newX][newY] <= height) continue;
        countIsland(mapStore, visited, newX, newY, height);
    }
}

function callBFS(mapStore, visited, height) {
    let tempCount = 0;
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < N; j++) {
            if (!visited[i][j] && mapStore[i][j] > height) {
                countIsland(mapStore, visited, i, j, height);
                tempCount++;
            }
        }
    }

    return tempCount;
}

let mapStore = input.slice(1).map(a => a.split(" ").map(Number));

for (let height = 0; height <= 100; height++) {
    let visited = Array.from({ length: N }, () => Array(N).fill(false));
    count = Math.max(count, callBFS(mapStore, visited, height));
}

console.log(count);
