const fs = require("fs");
let input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const targetNumInt = parseInt(input[0]);
const bannedDigits = (parseInt(input[1]) === 0) ? new Set() : new Set(input[2].split(" ").map(Number));

function isAllowed(num, bannedDigits) {
    let numStr = num.toString();
    for (let i = 0; i < numStr.length; i++) {
        if (bannedDigits.has(parseInt(numStr[i]))) {
            return false;
        }
    }
    return true;
}

function findClosestNum(targetNumInt, bannedDigits) {
    for (let i = 0; ; i++) {
        if (targetNumInt - i >= 0 && isAllowed(targetNumInt - i, bannedDigits)) {
            return targetNumInt - i;
        }
        if (isAllowed(targetNumInt + i, bannedDigits)) {
            return targetNumInt + i;
        }
    }
}

const pressFrom100 = Math.abs(targetNumInt - 100);
if(parseInt(input[1]) === 10) {
    console.log(pressFrom100);
} else {
    const closestNum = findClosestNum(targetNumInt, bannedDigits);
    const pressFromClosestNum = Math.abs(closestNum - targetNumInt) + closestNum.toString().length;

    const minPresses = Math.min(pressFromClosestNum, pressFrom100);
    console.log(minPresses);
}

