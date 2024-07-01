const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let N = parseInt(input[0]);

let inputWords = [];
let positionalWeights = new Map();

for (let i = 0; i < N; i++) {
    inputWords.push(input[i + 1]);
}

function calculatePositionalWeights() {
    for (let word of inputWords) {
        let len = word.length;
        for (let i = 0; i < len; i++) {
            let char = word[i];
            let weight = Math.pow(10, len - i - 1); // Calculate positional weight
            if (positionalWeights.has(char)) {
                positionalWeights.set(char, positionalWeights.get(char) + weight);
            } else {
                positionalWeights.set(char, weight);
            }
        }
    }
}

calculatePositionalWeights();

let charWeights = Array.from(positionalWeights.entries());
charWeights.sort((a, b) => b[1] - a[1]); // Sort by positional weight in descending order

console.log(charWeights);
let charToDigitMap = new Map();
let digit = 9;
for (let [char, weight] of charWeights) {
    charToDigitMap.set(char, digit);
    digit--;
}

function getNumVal(curWord) {
    let sum = 0;
    for (let i = 0; i < curWord.length; i++) {
        sum = (sum * 10) + charToDigitMap.get(curWord.charAt(i));
    }
    return sum;
}

let totalSum = 0;
for (let word of inputWords) {
    totalSum += getNumVal(word);
}

console.log(totalSum);
