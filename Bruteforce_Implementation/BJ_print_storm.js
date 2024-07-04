const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split(" ").map(a => parseInt(a));

let dX = [1, 0, -1, 0];
let dY = [0, -1, 0, 1];

function drawMap(input) {
    let N = Math.max(...input.map(a => Math.abs(a)));
    let LE = input[1] + N;
    let TE = input[0] + N;
    let RE = input[3] + N;
    let BE = input[2] + N;

    let map = {};

    let curX = N;
    let curY = N;
    let val = 1;

    map[`${curY},${curX}`] = val++;

    for (let i = 1; i <= N; i++) {
        let j = 0;
        while (j < 4) {
            switch (j) {
                case 0: // Move right
                    while (curX < N + i) {
                        curX += dX[j];
                        map[`${curY},${curX}`] = val++;
                    }
                    j++;
                    break;

                case 1: // Move up
                    while (curY > N - i) {
                        curY += dY[j];
                        map[`${curY},${curX}`] = val++;
                    }
                    j++;
                    break;

                case 2: // Move left
                    while (curX > N - i) {
                        curX += dX[j];
                        map[`${curY},${curX}`] = val++;
                    }
                    j++;
                    break;

                case 3: // Move down
                    while (curY < N + i) {
                        curY += dY[j];
                        map[`${curY},${curX}`] = val++;
                    }
                    j++;
                    break;
            }
        }
    }
    // Print the final right line
    while (curX < N + N) {
        curX += dX[0];
        map[`${curY},${curX}`] = val++;
    }

    for (let i = TE; i <= BE; i++) {
        let curRow = '';
        for (let j = LE; j <= RE; j++) {
            let value = map[`${i},${j}`] || 0;
            curRow += (value > 9) ? value + ' ' : ' ' + value + ' ';
        }
        console.log(curRow.trim());
    }
}

drawMap(input);