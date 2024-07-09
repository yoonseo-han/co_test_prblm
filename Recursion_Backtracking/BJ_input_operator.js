//https://www.acmicpc.net/problem/14888
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

function maxCombination(curInput, curInd, curSum, numOperator) {
    if (curInd === curInput.length) return curSum;

    let maxResult = -Infinity;

    for (let i = 0; i < 4; i++) {
        if (numOperator[i] > 0) {
            let temp = [...numOperator]; // Make a copy of numOperator
            temp[i]--;

            let nextSum;
            if (i === 0) nextSum = curSum + curInput[curInd];
            else if (i === 1) nextSum = curSum - curInput[curInd];
            else if (i === 2) nextSum = curSum * curInput[curInd];
            else if (i === 3) {
                if (curInput[curInd] === 0) continue; // Division by zero check
                if (curSum < 0) nextSum = (-1)*Math.floor(Math.abs(curSum) / curInput[curInd]);
                else nextSum = Math.floor(curSum / curInput[curInd]);
            }

            let result = maxCombination(curInput, curInd + 1, nextSum, temp);
            maxResult = Math.max(maxResult, result);
        }
    }

    return maxResult;
}

function minCombination(curInput, curInd, curSum, numOperator) {
    if (curInd === curInput.length) return curSum;

    let minResult = Infinity;

    for (let i = 0; i < 4; i++) {
        if (numOperator[i] > 0) {
            let temp = [...numOperator]; // Make a copy of numOperator
            temp[i]--;

            let nextSum;
            if (i === 0) nextSum = curSum + curInput[curInd];
            else if (i === 1) nextSum = curSum - curInput[curInd];
            else if (i === 2) nextSum = curSum * curInput[curInd];
            else if (i === 3) {
                if (curInput[curInd] === 0) continue; // Division by zero check
                if (curSum < 0) nextSum = (-1)*Math.floor(Math.abs(curSum) / curInput[curInd]);
                else nextSum = Math.floor(curSum / curInput[curInd]);
            }

            let result = minCombination(curInput, curInd + 1, nextSum, temp);
            minResult = Math.min(minResult, result);
        }
    }

    return minResult;
}

let N = parseInt(input[0]);
let numInput = input[1].split(" ").map(a => parseInt(a));
let numOperator = input[2].split(" ").map(a => parseInt(a));

let max = maxCombination(numInput, 1, numInput[0], numOperator);
let min = minCombination(numInput, 1, numInput[0], numOperator);

console.log(max ? max : 0);
console.log(min ? min : 0);
