const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const numPPL = parseInt(input[0]);
const numLVL = parseInt(input[1]);
const finalPosition = input[2].split("");

// Initialize the character positions
let storeChar = [];
for(let i = 0; i < numPPL; i++) {
    storeChar.push(String.fromCharCode(65 + i));
}

const inputStore = input.slice(3);
const stringToFind = "?".repeat(numPPL - 1);
const stopIndex = inputStore.indexOf(stringToFind);

// Process from the top to the stop index
let latestRow = [...storeChar];
for(let i = 0; i < stopIndex; i++) {
    let curRowStore = inputStore[i].split("");
    for (let j = 0; j < curRowStore.length; j++) {
        if (curRowStore[j] === "-") {
            // Swap the characters
            [latestRow[j], latestRow[j + 1]] = [latestRow[j + 1], latestRow[j]];
        }
    }
}

// Process from the bottom to the stop index
let reverseLatestRow = [...finalPosition];
for(let i = numLVL - 1; i > stopIndex; i--) {
    let curRowStore = inputStore[i].split("");
    for (let j = 0; j < curRowStore.length; j++) {
        if (curRowStore[j] === "-") {
            // Swap the characters
            [reverseLatestRow[j], reverseLatestRow[j + 1]] = [reverseLatestRow[j + 1], reverseLatestRow[j]];
        }
    }
}

// Determine the missing row configuration
let answer = new Array(numPPL - 1).fill("*");

for(let i = 0; i < reverseLatestRow.length - 1; i++) {
    if (reverseLatestRow[i] !== latestRow[i]) {
        if (reverseLatestRow[i] === latestRow[i + 1] && reverseLatestRow[i + 1] === latestRow[i]) {
            answer[i] = "-";
            i++;  // Skip next index since we already swapped
        } else {
            console.log("x".repeat(numPPL - 1));
            return;
        }
    }
}

console.log(answer.join(""));
