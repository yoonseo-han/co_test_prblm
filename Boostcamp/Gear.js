const fs = require('fs');
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

function rotateGear(gearStore, gearPosition, rotationDirection) {
    if (rotationDirection === 1) {
        // Rotate to the right
        const lastElement = gearStore[gearPosition].pop();
        gearStore[gearPosition].unshift(lastElement);
    } else {
        // Rotate to the left
        const firstElement = gearStore[gearPosition].shift();
        gearStore[gearPosition].push(firstElement);
    }
}

function propagateRotation(gearStore, curGear, curDir, curStatus) {
    curStatus[curGear] = curDir;
    
    // Check and propagate to the right
    if (curGear < 3 && curStatus[curGear + 1] === 0) {
        if (gearStore[curGear][2] !== gearStore[curGear + 1][6]) {
            propagateRotation(gearStore, curGear + 1, -curDir, curStatus);
        }
    }
    
    // Check and propagate to the left
    if (curGear > 0 && curStatus[curGear - 1] === 0) {
        if (gearStore[curGear][6] !== gearStore[curGear - 1][2]) {
            propagateRotation(gearStore, curGear - 1, -curDir, curStatus);
        }
    }
}

var gearStore = [];
for (let i = 0; i < 4; i++) {
    gearStore[i] = input[i].split('').map(element => parseInt(element));
}

// Store the rotation operations
let numOperations = parseInt(input[4]);
for (let i = 0; i < numOperations; i++) {
    let curGear = parseInt(input[5 + i].split(" ")[0]) - 1;
    let curDir = parseInt(input[5 + i].split(" ")[1]);

    // Initialize rotation status array
    var curStatus = [0, 0, 0, 0];
    propagateRotation(gearStore, curGear, curDir, curStatus);

    // Apply rotations based on the status array
    for (let j = 0; j < 4; j++) {
        if (curStatus[j] !== 0) {
            rotateGear(gearStore, j, curStatus[j]);
        }
    }
}

// Calculate score of the final configuration
let score = gearStore[0][0] + (2 * gearStore[1][0]) + (4 * gearStore[2][0]) + (8 * gearStore[3][0]);
console.log(score);
