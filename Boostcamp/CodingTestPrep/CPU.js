const fs = require('fs');
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

let N = parseInt(input[0]);
let opcodeStore = ["ADD", "SUB", "MOV", "AND", "OR" , "NOT", "MULT", "LSFTL", "LSFTR", "ASFTR", "RL", "RR"];

const getBinary = function(dec) {
    return (dec >>> 0).toString(2);
}

for(let i = 1; i<N+1; i++) {
    let curString = input[i].split(" ");
    let returnString = "";

    //opcode indicator
    let curOpcode = curString[0];
    let opcodeIndicator = 0;
    if(curOpcode.charAt(curOpcode.length-1) === "C"){
        opcodeIndicator=1;
        curOpcode = curOpcode.slice(0,curOpcode.length-1);
    }
    for(let j = 0; j < opcodeStore.length; j++) {
        if(opcodeStore[j] === curOpcode) {
            returnString += getBinary(j).toString().padStart(4, "0");
            returnString += opcodeIndicator.toString();
            returnString += "0";
            break;
        }
    }
    //rD
    let rdVal = parseInt(curString[1]);
    returnString += getBinary(rdVal).toString().padStart(3, "0");

    //rA value
    let raVal = parseInt(curString[2]);
    if(curOpcode == "NOT" || curOpcode == "MOV") raVal = 0;

    returnString += getBinary(raVal).toString().padStart(3, "0");

    //Determine based on opcode value
    if(opcodeIndicator == 1) {
        let numC = parseInt(curString[3]);
        returnString += getBinary(numC).toString().padStart(4, "0");
    } else {
        let rbVal = parseInt(curString[3]);
        returnString += getBinary(rbVal).toString().padStart(3, "0");
        returnString += "0";
    }

    console.log(returnString);
}