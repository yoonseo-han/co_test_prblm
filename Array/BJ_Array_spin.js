const fs = require("fs");
let input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let [N, M, iter] = input[0].split(" ").map(a => parseInt(a));
//console.log(N, M, iter);
let map = input.splice(1).map(a => a.split(" ").map(curElement => parseInt(curElement)));

let dx = [0, 1, 0, -1];
let dy = [1, 0, -1, 0];

function rotateLayer(map, layer) {
    let startX = layer, startY = layer;
    let endX = M - layer - 1, endY = N - layer - 1;

    if (startX >= endX || startY >= endY) return;

    let curX = startX, curY = startY;
    let curDirection = 0;
    let firstVal = map[startY][startX];
    let temp = firstVal;

    for (let i = 0; i < 2 * (endX - startX + endY - startY); i++) {
        let nextX = curX + dx[curDirection];
        let nextY = curY + dy[curDirection];

        if (nextX >= startX && nextX <= endX && nextY >= startY && nextY <= endY) {
            let nextTemp = map[nextY][nextX];
            map[nextY][nextX] = temp;
            temp = nextTemp;

            curX = nextX;
            curY = nextY;

            if ((curX === startX && curY === endY) || (curX === endX && curY === endY) || (curX === endX && curY === startY)) {
                curDirection = (curDirection + 1) % 4;
            }
        }
    }
}

function printMap(map) {
    let output = '';
    map.forEach((curRow) => {
        curRow.forEach((curElement) => output += `${curElement} `);
        output+='\n';
    })
    console.log(output);
}

for (let k = 0; k < iter; k++) {
    let layers = Math.floor(Math.min(N, M) / 2);
    for (let layer = 0; layer < layers; layer++) {
        rotateLayer(map, layer);
    }
}

printMap(map);