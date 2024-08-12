const fs = require("fs");
let input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let map = input.slice(1).map(row => row.split(" ").map(Number));
let rows = map.length;
let cols = map[0].length;
let dx = [-1, 1, 0, 0];
let dy = [0, 0, 1, -1];

function bfsTomato(map) {
    const deque = [];
    const dist = Array.from({ length: rows }, () => Array(cols).fill(-1));
    let numEmpty = 0;

    // Initialize the queue and the dist array
    for (let y = 0; y < rows; y++) {
        for (let x = 0; x < cols; x++) {
            if (map[y][x] === 1) {
                deque.push([y, x]);
                dist[y][x] = 0;
            } else if (map[y][x] === 0) {
                numEmpty++;
            }
        }
    }

    if (numEmpty === 0) return 0;

    let days = 0;
    while (deque.length > 0) {
        let [curY, curX] = deque.shift();

        for (let i = 0; i < 4; i++) {
            let newY = curY + dy[i];
            let newX = curX + dx[i];

            if (newY >= 0 && newX >= 0 && newY < rows && newX < cols && dist[newY][newX] === -1 && map[newY][newX] === 0) {
                dist[newY][newX] = dist[curY][curX] + 1;
                deque.push([newY, newX]);
                days = Math.max(days, dist[newY][newX]);
                numEmpty--;

                if (numEmpty === 0) return days;
            }
        }
    }

    // If there are still unripe tomatoes left
    return -1;
}

console.log(bfsTomato(map));