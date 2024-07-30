//https://www.acmicpc.net/problem/10799
const Stack = require('./Stack');
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("");

//let parseInput = new Stack();
let parseInput = [];

function isLaser(array, curInd) {
    return curInd + 1 < array.length && array[curInd] === "(" && array[curInd + 1] === ")";
}

function findRespectivePairAndLaser(array, curInd) {
    let curLaser = 0;
    let tempStack = new Stack();
    for(let i = curInd; i < array.length; i++) {
        if(array[i] === '(') {
            tempStack.push('(');
        } else if(array[i] === ')') {
            tempStack.pop();
            if(tempStack.isEmpty()) {
                return curLaser;
            }
        } else if(array[i] > 0 &&  array[i] < 10) {
            curLaser += array[i];
        }
    }
    return 0;
}

let answer = 0;
for(let i = 0; i<input.length; i++) {
    if(isLaser(input, i)) {
        if(parseInput[parseInput.length-1] >= 0 && parseInput[parseInput.length-1] <=input.length) parseInput[parseInput.length-1] = parseInput[parseInput.length-1] + 1;
        else parseInput.push(1);
        i++;
    } else parseInput.push(input[i]);
}

for (let i = 0; i < parseInput.length; i++) {
    if (parseInput[i] === '(') {
        answer += (findRespectivePairAndLaser(parseInput, i) + 1);
    }
}

console.log(answer);