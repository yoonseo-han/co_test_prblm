//https://www.acmicpc.net/problem/20207

const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const scheduleStore = input.slice(1).map((curRow) =>
    curRow.split(" ").map((element) => parseInt(element, 10))
);

scheduleStore.sort((a, b) => {
    if (a[0] === b[0]) return b[1] - a[1];
    return a[0] - b[0];
});

const smallest = scheduleStore[0][0];
const largest = scheduleStore[scheduleStore.length - 1][1];

let map = [];
map.push(new Array(largest - smallest + 1).fill(0));

scheduleStore.forEach((curSchedule) => {
    const curLeft = curSchedule[0];
    const curRight = curSchedule[1];

    let placed = false;
    for (let i = 0; i < map.length; i++) {
        if (map[i].slice(curLeft - smallest, curRight - smallest + 1).every(val => val === 0)) {
            map[i].fill(1, curLeft - smallest, curRight - smallest + 1);
            placed = true;
            break;
        }
    }
    if (!placed) {
        let newRow = new Array(largest - smallest + 1).fill(0);
        newRow.fill(1, curLeft - smallest, curRight - smallest + 1);
        map.push(newRow);
    }
});

let curArea = 0;
let curMaxWidth = 0;
let curMaxHeight = 0;
for (let i = 0; i < map[0].length; i++) {
    let curHeight = 0;
    for (let j = 0; j < map.length; j++) {
        if (map[j][i] === 1) curHeight++;
    }
    if (curHeight > 0) {
        curMaxWidth++;
        curMaxHeight = Math.max(curHeight, curMaxHeight);
    } else {
        curArea += curMaxHeight * curMaxWidth;
        curMaxWidth = 0;
        curMaxHeight = 0;
    }
}

if (curMaxWidth > 0) {
    curArea += curMaxHeight * curMaxWidth;
}

console.log(curArea);