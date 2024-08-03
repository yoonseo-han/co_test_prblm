const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

function makeMap(curRow) {
    let element = curRow.split("");
    let map = [];
    for (let i = 0; i < 3; i++) {
        map.push(element.slice(i * 3, i * 3 + 3));
    }
    return map;
}

function numValidity(curMap) {
    let numX = 0;
    let numO = 0;
    curMap.forEach((curRow) => {
        curRow.forEach(curElement => (curElement === 'X') ? numX++ : (curElement === 'O') ? numO++ : null);
    });
    return numX === numO || numX === numO + 1;
}

function checkRowAndCol(curMap, i, curElement) {
    let count = 0;
    if (curMap[i][0] === curMap[i][1] && curMap[i][1] === curMap[i][2] && curMap[i][0] === curElement) count++;
    if (curMap[0][i] === curMap[1][i] && curMap[1][i] === curMap[2][i] && curMap[0][i] === curElement) count++;
    return count;
}

function checkDiagonal(curMap, curElement) {
    let count = 0;
    if (curMap[0][0] === curMap[1][1] && curMap[1][1] === curMap[2][2] && curMap[0][0] === curElement) count++;
    if (curMap[2][0] === curMap[1][1] && curMap[1][1] === curMap[0][2] && curMap[2][0] === curElement) count++;
    return count;
}

function checkWinNum(curMap, curElement) {
    let count = 0;
    for (let i = 0; i < 3; i++) {
        count += checkRowAndCol(curMap, i, curElement);
    }
    count += checkDiagonal(curMap, curElement);
    return count;
}

function isValidTicTacToe(curMap) {
    const xWins = checkWinNum(curMap, 'X');
    const oWins = checkWinNum(curMap, 'O');

    if (xWins >= 1 && oWins >= 1) {
        return false;
    }
    const numX = curMap.flat().filter(c => c === 'X').length;
    const numO = curMap.flat().filter(c => c === 'O').length;
    if (xWins >= 1 && oWins === 0 && numX !== numO + 1) {
        return false;
    }
    if (oWins >= 1 && xWins === 0 && numX !== numO) {
        return false;
    }
    if(xWins === 0 && oWins === 0 && numX + numO < 9) {
        return false;
    } 
    return true;
}

// Remove the last empty input line if it exists
input.pop();

input.forEach((curRow) => {
    let curMap = makeMap(curRow);
    if (!numValidity(curMap) || !isValidTicTacToe(curMap)) {
        console.log("invalid");
    } else {
        console.log("valid");
    }
});
