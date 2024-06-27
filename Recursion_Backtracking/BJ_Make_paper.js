const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let N = parseInt(input[0]);

let countBlue = 0;
let countWhite = 0;

let map = [];
for (let i = 0; i < N; i++) {
    let curLine = input[i + 1].split(" ").map(a => parseInt(a));
    map.push(curLine);
}

function recursiveCall(startY, startX, curN) {
    // Determine the color of the current section
    let curCol = map[startY][startX];
    // Go through every element in the array and check if it is the same color
    let flag = true;
    for (let i = 0; i < curN; i++) {
        for (let j = 0; j < curN; j++) {
            if (map[startY + i][startX + j] !== curCol) {
                flag = false;
                break;
            }
        }
        if (!flag) break;
    }

    if (curN === 1 || flag) {
        if (curCol === 1) countBlue++;
        else countWhite++;
        return;
    } else {
        // Generate 4 small subparts
        let halfN = Math.floor(curN / 2);
        recursiveCall(startY, startX, halfN);
        recursiveCall(startY + halfN, startX, halfN);
        recursiveCall(startY, startX + halfN, halfN);
        recursiveCall(startY + halfN, startX + halfN, halfN);
    }
}

recursiveCall(0, 0, N);
console.log(countWhite);
console.log(countBlue);
