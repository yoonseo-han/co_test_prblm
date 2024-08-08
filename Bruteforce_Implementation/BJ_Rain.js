const fs = require("fs");
let input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const [height, width] = input[0].split(" ").map(a => parseInt(a));
const pillarStore = input[1].split(" ").map(a => parseInt(a));

let totalWater = 0;

let leftPointer = 0;
let rightPointer = width - 1;
let leftMax = pillarStore[leftPointer];
let rightMax = pillarStore[rightPointer];

while (leftPointer < rightPointer) {
    if (pillarStore[leftPointer] <= pillarStore[rightPointer]) {
        leftPointer++;
        leftMax = Math.max(leftMax, pillarStore[leftPointer]);
        totalWater += Math.max(0, leftMax - pillarStore[leftPointer]);
    } else {
        rightPointer--;
        rightMax = Math.max(rightMax, pillarStore[rightPointer]);
        totalWater += Math.max(0, rightMax - pillarStore[rightPointer]);
    }
}

console.log(totalWater);
