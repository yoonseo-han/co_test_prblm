const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const mapStore = input.slice(1).map(a => a.split(''));
let height = mapStore.length;
let width = mapStore[0].length;
let max = 0;

const dx = [-1, 1, 0, 0];
const dy = [0, 0, 1, -1];

function bfs(startX, startY) {
    let queue = [[startX, startY, 0]];
    let visited = Array.from({ length: height }, () => Array(width).fill(false));
    visited[startY][startX] = true;
    let maxDistance = 0;

    while (queue.length > 0) {
        let [x, y, dist] = queue.shift();
        maxDistance = Math.max(maxDistance, dist);

        for (let i = 0; i < 4; i++) {
            let newX = x + dx[i];
            let newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < width && newY < height && !visited[newY][newX] && mapStore[newY][newX] === 'L') {
                visited[newY][newX] = true;
                queue.push([newX, newY, dist + 1]);
            }
        }
    }

    return maxDistance;
}

for (let i = 0; i < height; i++) {
    for (let j = 0; j < width; j++) {
        if (mapStore[i][j] === 'L') {
            max = Math.max(max, bfs(j, i));
        }
    }
}

console.log(max);