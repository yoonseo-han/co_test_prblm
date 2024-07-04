const fs = require("fs");
let input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("");

let orderStore = ['q', 'u', 'a', 'c', 'k'];
let map = new Map();
map.set('q', 0);
map.set('u', 0);
map.set('a', 0);
map.set('c', 0);
map.set('k', 0);

let answer = 0;
let curIDX = 0;
let numDuck = 0;
let counts = [];

for (let curChar of input) {
    let curOrder = orderStore.indexOf(curChar);
    if (curOrder === -1) continue; // Skip invalid characters

    let curCount = map.get(curChar);
    for (let i = 0; i < curOrder; i++) {
        if (map.get(orderStore[i]) <= curCount) {
            answer = -1;
            break;
        }
    }
    if (answer === -1) break;
    counts[curIDX++] = curCount;
    map.set(curChar, curCount + 1);
    numDuck = Math.max(numDuck, curCount + 1);
}

for (let [key, value] of map) {
    if(value !== numDuck) answer = -1;
}

if (answer === -1) {
    console.log(answer);
} else {
    let storeRange = new Array(numDuck).fill(0).map(() => new Array(2).fill(-1));

    curIDX = 0;
    for (let curNum of counts) {
        if (storeRange[curNum][0] == -1) {
            storeRange[curNum][0] = curIDX;
        } else {
            storeRange[curNum][1] = Math.max(storeRange[curNum][1], curIDX);
        }
        curIDX++;
    }

    for (let curRange of storeRange) {
        if (curRange[0] === -1 || curRange[1] === -1) continue; // Skip incomplete ranges

        let curPos = curRange[1];
        let curCount = 0;
        for (let i = 0; i < storeRange.length; i++) {
            if (storeRange[i][0] <= curPos && storeRange[i][1] >= curPos) {
                curCount++;
            }
        }
        answer = Math.max(answer, curCount);
    }
    console.log(answer);
}
