//https://www.acmicpc.net/problem/24511
const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

// const {Queue} = require('./Queue');
// const {Stack} = require('./Stack');
class Stack {
    constructor() {
        this.list = [];
        this.size = 0;
    }
    push(curNum) {
        this.list[this.size++] = curNum;
    }
    pop() {
        if(this.size <= 0) return null;
        return this.list.splice(--this.size, 1).reduce((acc, cur) => {
            return acc;
        })
    }

    isEmpty() {
        if(this.index == 0) return true;
        else return false;
    }
}

class Queue{
    constructor() {
        this.list = [];
        this.size = 0;
    }

    push(curNum) {
        this.list[this.size++] = curNum;
    }

    pop() {
        if (this.index <= 0) return null;
        this.size--;
        return this.list.splice(0,1).reduce((acc, cur) => {
            return acc;
        });
    }

    isEmpty() {
        if(this.index == 0) return true;
        else return false;
    }
}


let size = parseInt(input[0]);
let dsType = input[1].split(" ").map(a => parseInt(a));
let dsInput = input[2].split(" ").map(a => parseInt(a));
let consoleInput = input[4].split(" ").map(a => parseInt(a));

let dsStore = [];

let curIDX = 0;

for(curType of dsType) {
    if(curType == 0) {
        //Store Queue
        dsStore[curIDX] = new Queue();
    }
    else {
        //Store stack
        dsStore[curIDX] = new Stack();
    }
    dsStore[curIDX].push(dsInput[curIDX]);
    curIDX++;
}

answer = ''
for(curInput of consoleInput) {
    let passInt = curInput;
    for(let i = 0; i<size; i++) {
        //First insert curInput to datatype
        dsStore[i].push(passInt);
        passInt = dsStore[i].pop();
        //If reach end
        if(i == size-1) answer += (passInt + ' ');
    }
}
console.log(answer);