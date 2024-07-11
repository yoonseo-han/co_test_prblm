//https://www.acmicpc.net/problem/9184
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

//Initialization of 3d array
let dp = Array.from({ length: 21 }, () => 
    Array.from({ length: 21 }, () => 
        Array(21).fill(0)
    )
);

//Fill in DP table
for (let i = 0; i <= 20; i++) {
    for (let j = 0; j <= 20; j++) {
        for (let k = 0; k <= 20; k++) {
            if (i <= 0 || j <= 0 || k <= 0) {
                dp[i][j][k] = 1;
            } else if (i < j && j < k) {
                dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
            } else {
                dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
            }
        }
    }
}

// Define the main function to use the precomputed DP table
function wDP(a, b, c) {
    if (a <= 0 || b <= 0 || c <= 0) return 1;
    if (a > 20 || b > 20 || c > 20) return dp[20][20][20];
    return dp[a][b][c];
}
let answer = '';
for(curInput of input) {
    let parsedInput = curInput.split(" ").map(a => parseInt(a));
    if(parsedInput[0] === -1 && parsedInput[1] === -1 && parsedInput[2] === -1) break;
    let first = parsedInput[0];
    let second = parsedInput[1];
    let third = parsedInput[2];

    answer +=`w(${first}, ${second}, ${third}) = ${wDP(first, second, third)}\n`;
}
console.log(answer);