//https://www.acmicpc.net/problem/18870
const fs = require("fs");
let input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let N = parseInt(input[0]);
let inputInt = input[1].split(" ").map(a => parseInt(a));

// Use a Set to remove duplicates
let storeInt = Array.from(new Set(inputInt));

// Sort the unique values
storeInt.sort((a, b) => a - b);

// Create a map to store the compressed coordinates
let storeInfo = new Map();
for (let i = 0; i < storeInt.length; i++) {
    storeInfo.set(storeInt[i], i);
}

// Map each input value to its compressed coordinate
let result = inputInt.map(a => storeInfo.get(a));
console.log(result.join(" "));
