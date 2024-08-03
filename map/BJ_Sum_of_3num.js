//https://www.acmicpc.net/problem/2295
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let N = parseInt(input[0]);
let numArr = input.splice(1).map(a => parseInt(a)).sort(function(a, b){return b - a});

let result = 0;
const possibleSums = new Set();
for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        possibleSums.add(numArr[i] + numArr[j]);
    }
}

for (let k = 0; k < N; k++) {
    for (let l = 0; l < N; l++) {
        if (k !== l) {
            let target = numArr[k];
            let sum = numArr[l];
            if (possibleSums.has(target - sum)) {
                result = numArr[k];
                break;
            }
        }
    }
    if (result) break;
}

console.log(result);
