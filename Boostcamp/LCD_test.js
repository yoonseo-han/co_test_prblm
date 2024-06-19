const fs = require('fs');
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split(" ");

let len = parseInt(input[0]);

let num = input[1];
let numOfInteger = num.length;
let width  = len+2;
let height = 2*len + 3;

let top = 0;
let mid = Math.floor((2*len+3)/2);
let bottom = 2*num+2;


for(let i = 0; i < height; i++) {
    for(let j = 0; j < numOfInteger; j++) {
        let curNum = parseInt(num.charAt(j));

        for(let k = 0; k<width; k++) {
            if(i == 0 || i == height-1) {
                if(curNum === 0 || curNum === 2 || curNum === 3 || curNum === 5 || curNum === 6 || curNum === 8 || curNum === 9){
                    if(k!=0 && k != width-1) process.stdout.write("-");
                    else process.stdout.write(" ");
                }
                else if(curNum == 7 && i == 0) {
                    if(k!=0 && k != width-1) process.stdout.write("-");
                    else process.stdout.write(" ");
                }
                else process.stdout.write(" ");
            }
            else if(i == mid){
                if(curNum === 2 || curNum === 3 || curNum === 4 || curNum === 5 || curNum === 6 || curNum === 8 || curNum === 9) {
                    if(k!=0 && k != width-1) process.stdout.write("-");
                    else process.stdout.write(" ");
                }
                else process.stdout.write(" ");
            }
            else if(k == 0 || k ==width-1){
                if(k==0) { //Print left side
                    //Print upper left side
                    if(i < mid && (curNum == 0 || curNum == 4 || curNum == 5 || curNum ==6 || curNum ==8 ||curNum ==9)) process.stdout.write("|");
                    //Print lower left side
                    else if (i > mid && (curNum == 2 || curNum == 6 || curNum == 8 || curNum == 0)) process.stdout.write("|");
                    else process.stdout.write(" ");
                }
                else if ( k ==width-1) { // print right side
                    //Print upper right side
                    if(i < mid && (curNum == 1 || curNum == 2 || curNum == 3 || curNum == 4 || curNum == 7|| curNum == 8 || curNum == 9 ||curNum == 0)) process.stdout.write("|");
                    //Print lower right side
                    else if (i > mid && (curNum == 1 || curNum == 3 || curNum == 4 || curNum == 5 || curNum == 6 ||curNum == 7|| curNum == 8 || curNum == 9 || curNum == 0)) process.stdout.write("|");
                    else process.stdout.write(" ");
                }
            }
            else {
                process.stdout.write(" ");
            }
        }

        //After print one num: print blank space for separation
        process.stdout.write(" ");
    }
    console.log("");
}