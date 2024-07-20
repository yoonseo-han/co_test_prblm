const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let N = parseInt(input[0]);
let inputStore = input.slice(1).map(a => a.split(" ").map(a => parseInt(a)));
let dp = Array(N + 1).fill(0);  // N+1 to handle the dp[i + inputStore[i][0]] indexing

for (let i = N - 1; i >= 0; i--) {
    if (i + inputStore[i][0] > N) {
        dp[i] = dp[i + 1];  // If the task cannot be completed, carry forward the previous value
    } else {
        dp[i] = Math.max(dp[i + 1], inputStore[i][1] + (i + inputStore[i][0] <= N ? dp[i + inputStore[i][0]] : 0));
    }
}

console.log(dp[0]);
