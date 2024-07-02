const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim();

let left = 0;
let right = 1;

let numbers = [];
let signs = [];
let negInd = null;

while(right < input.length) {
    if(input[right] === '+' || input[right] === '-') {
        signs.push(input.charAt(right));

        //Store the number 
        let curNum = parseInt(input.substring(left, right));
        numbers.push(curNum);

        //Store neg sign index
        if(input.charAt(right) === '-' && negInd == null) negInd = signs.length;

        //Adjust the left and right position
        right++;
        left = right;
    }
    else {
        right++;
    }
}
//Add the last number
numbers.push(parseInt(input.substring(left)));

// console.log(numbers, signs);
//console.log(negInd);
let sum = 0;
for(let i = 0; i<numbers.length; i++) {
    if(i >= negInd && negInd!==null) sum-=numbers[i];
    else sum+= numbers[i];
}
console.log(sum);