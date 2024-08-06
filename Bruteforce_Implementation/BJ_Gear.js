const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const N = parseInt(input[0]);
let gearStore = input.slice(1, N + 1).map(curGear => curGear.split(""));

let cmdNumber = parseInt(input[N+1]);
let cmdStore = input.slice(N+2).map(curCmd => curCmd.split(" ").map(Number));

function rotateGear(gear, direction) {
    if (direction === 1) {
        // Clockwise
        const lastElement = gear.pop();
        gear.unshift(lastElement);
    } else {
        // Counter-clockwise
        const firstElement = gear.shift();
        gear.push(firstElement);
    }
}

cmdStore.forEach((curCMD) => {
    const [gearID, direction] = [curCMD[0] - 1, curCMD[1]];
    const directions = Array(N).fill(0);
    directions[gearID] = direction;

    // Propagate rotation to the left
    for (let i = gearID; i > 0; i--) {
        if (gearStore[i][6] !== gearStore[i - 1][2]) {
            directions[i - 1] = -directions[i];
        } else {
            break;
        }
    }

    // Propagate rotation to the right
    for (let i = gearID; i < N - 1; i++) {
        if (gearStore[i][2] !== gearStore[i + 1][6]) {
            directions[i + 1] = -directions[i];
        } else {
            break;
        }
    }

    // Apply the rotations
    for (let i = 0; i < N; i++) {
        if (directions[i] !== 0) {
            rotateGear(gearStore[i], directions[i]);
        }
    }
});

let gearPosition = gearStore.filter((curGear) => curGear[0] === '1');
console.log(gearPosition.length);
