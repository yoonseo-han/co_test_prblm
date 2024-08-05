const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let gradeScore = {
    'A+' : 4.5,
    'A0' : 4.0,
    'B+' : 3.5,
    'B0' : 3.0,
    'C+' : 2.5,
    'C0' : 2.0,
    'D+' : 1.5,
    'D0' : 1.0,
    'F' : 0.0
}

let totalScore = 0;
let totalCredit = 0;

input.forEach((curLine) => {
    let [_, curCredit, curScore] = curLine.split(" ");

    if(curScore === 'P') return;

    totalCredit += parseFloat(curCredit);
    totalScore += parseFloat(curCredit) * gradeScore[curScore];
});
console.log(totalScore / totalCredit);