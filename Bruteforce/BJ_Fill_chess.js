const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let M = parseInt(input[0].split(" ")[0]);
let N = parseInt(input[0].split(" ")[1]);

let chessBoard = [];
let startB = { 0: 'B', 1: 'W' };
let startW = { 0: 'W', 1: 'B' };

for (let i = 0; i < M; i++) {
    let curLine = input[i + 1].split("");
    chessBoard.push(curLine);
}

function determineBoard(startY, startX) {
    let countB = 0;
    let countW = 0;

    for (let row = 0; row < 8; row++) {
        for (let col = 0; col < 8; col++) {
            let currentChar = chessBoard[startY + row][startX + col];
            let expectedCharB = startB[(row + col) % 2];
            let expectedCharW = startW[(row + col) % 2];

            if (currentChar !== expectedCharB) countB++;
            if (currentChar !== expectedCharW) countW++;
        }
    }

    return Math.min(countB, countW);
}

let minCount = Infinity;

for (let i = 0; i <= M - 8; i++) {
    for (let j = 0; j <= N - 8; j++) {
        let currentMin = determineBoard(i, j);
        if (currentMin < minCount) {
            minCount = currentMin;
        }
    }
}

console.log(minCount);
