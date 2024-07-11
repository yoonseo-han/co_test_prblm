//https://www.acmicpc.net/problem/11050
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split(" ").map(a => parseInt(a));

let N = input[0];
let K = input[1];

function getMultiple(start, end) {
    let sum = 1;
    for(let i = start; i<=end; i++) sum*=i;
    return sum;
}
console.log(getMultiple(N-K+1, N) / getMultiple(1, K));