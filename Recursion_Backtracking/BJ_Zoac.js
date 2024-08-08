const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

function findSmallestSubset(inputString, start, N) {
    let smallest = null;

    function generateAndCheck(curString, start) {
        if(curString.length === N) {
            if (smallest === null || curString < smallest) {
                smallest = curString;
            }
            return;
        } else {
            for(let i = start; i < inputString.length; i++) {
                generateAndCheck(curString + inputString[i], i + 1);
            }
        }
    }

    generateAndCheck('', start);
    return smallest;
}

const inputString = input[0];
let answer = [];
for(let i = 1; i <= inputString.length; i++) {
    let smallestSubset = findSmallestSubset(inputString, 0, i);
    answer.push(smallestSubset);
}
answer.forEach(curElement => console.log(curElement));
