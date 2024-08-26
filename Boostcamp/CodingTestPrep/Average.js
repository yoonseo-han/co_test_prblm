const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const number = Number(input[0]);

for (let i = 1; i <= number; i++) {
    const arr = input[i].split(" ");
    const length = arr[0];
    let total = 0;
    for (let j = 1; j <= length; j++) {
        total += Number(arr[j]);
    }
    let avg = total / length;
    let overTotal = 0;
    for (let j = 1; j <= length; j++) {
        if (avg < arr[j]) {
            overTotal++;
        }
    }
    console.log(((overTotal / length) * 100).toFixed(3) + "%");
}