const fs = require('fs');
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

// Movements array for the dice: [top, east, west, north, south]
// When moving east, west, north, or south, these arrays provide the new top face values
const mvmnt = [
    [0],              // Placeholder for 0-indexing
    [0, 5, 6, 3, 4],  // Movements for when bottom face is 1
    [0, 6, 5, 3, 4],  // Movements for when bottom face is 2
    [0, 4, 3, 2, 1],  // Movements for when bottom face is 3
    [0, 3, 4, 1, 2],  // Movements for when bottom face is 4
    [0, 1, 2, 3, 4],  // Movements for when bottom face is 5
    [0, 2, 1, 4, 3]   // Movements for when bottom face is 6
];

let firstInput = input[0].split(" ").map(element => parseInt(element));

let height = firstInput[0];
let width = firstInput[1];
let curX = firstInput[2];
let curY = firstInput[3];
let numOperations = firstInput[4];

let storeVal = new Map([
    [1, 0],
    [2, 0],
    [3, 0],
    [4, 0],
    [5, 0],
    [6, 0]
]);

// Initialize the map store
let mapStore = [];
for (let i = 1; i <= height; i++) {
    mapStore.push(input[i].split(" ").map(element => parseInt(element)));
}

// Define movement deltas: [no move, east, west, north, south]
let dX = [0, 1, -1, 0, 0];
let dY = [0, 0, 0, -1, 1];

let operations = input[1 + height].split(" ").map(element => parseInt(element));
let curID = 1;  // Starting top face is 1

for (let i = 0; i < numOperations; i++) {
    let curOp = operations[i];

    // Check boundaries
    if (curX + dX[curOp] < 0 || curY + dY[curOp] < 0 || curX + dX[curOp] >= width || curY + dY[curOp] >= height) continue;

    // Do the movement
    curX += dX[curOp];
    curY += dY[curOp];
    curID = mvmnt[curID][curOp];

    let curUpID = 7 - curID;

    if (mapStore[curY][curX] == 0) {
        mapStore[curY][curX] = storeVal.get(curID);
    } else {
        storeVal.set(curID, mapStore[curY][curX]);
        mapStore[curY][curX] = 0;
    }

    // Print the value on the top of the dice after each move
    console.log(storeVal.get(curUpID));
}
