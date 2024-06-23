const fs = require('fs');
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const firstLine = input[0].split(" ").map(Number);
const Y = firstLine[0];
const X = firstLine[1];
let curY = firstLine[2];
let curX = firstLine[3];
const k = firstLine[4];

const map = [];
for (let i = 1; i <= Y; i++) {
    map.push(input[i].split(" ").map(Number));
}

const operations = input[Y + 1].split(" ").map(Number);

// Dice configuration: [top, bottom, north, south, east, west]
let dice = [0, 0, 0, 0, 0, 0];

// Movements: east, west, north, south
const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

const result = [];

function simulation(dir) {
    const nx = curX + dx[dir];
    const ny = curY + dy[dir];

    // Check boundaries
    if (nx < 0 || ny < 0 || nx >= X || ny >= Y) return;

    let temp;
    switch (dir) {
        // East
        case 0:
            temp = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[0];
            dice[0] = dice[2];
            dice[2] = temp;
            break;
        // West
        case 1:
            temp = dice[5];
            dice[5] = dice[2];
            dice[2] = dice[0];
            dice[0] = dice[4];
            dice[4] = temp;
            break;
        // North
        case 2:
            temp = dice[5];
            dice[5] = dice[3];
            dice[3] = dice[0];
            dice[0] = dice[1];
            dice[1] = temp;
            break;
        // South
        case 3:
            temp = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[0];
            dice[0] = dice[3];
            dice[3] = temp;
    }

    result.push(dice[0]);

    // Update coordinates
    curX = nx;
    curY = ny;

    // If map cell is 0, copy dice bottom to map
    if (map[curY][curX] === 0) {
        map[curY][curX] = dice[5];
    } else {
        // Copy map value to dice bottom and set map cell to 0
        dice[5] = map[curY][curX];
        map[curY][curX] = 0;
    }
}

operations.forEach(op => simulation(op - 1));
console.log(result.join("\n"));
