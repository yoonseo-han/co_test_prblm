const fs = require("fs");
const input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

const dx = [-1,1,0,0];
const dy = [0,0,-1,1];

const N = parseInt(input[0]);
let map = new Array(N).fill(0).map(a => new Array(N).fill(0));

function getCloseStudentNum(studentID, closeFriends, map) {
    const mapCopy = map.map((curRow) => {
        return curRow.slice();
    })
    let seatList = [];
    let maxFriends = -1;
    mapCopy.map((curRow, rowInd) => {
        curRow.forEach((curElement, colInd) => {
            if(curElement !== 0) return;
            else  {
                //Get number of close friends 
                let tempCount = 0;
                for(let i = 0; i<4; i++) {
                    let newX = colInd + dx[i];
                    let newY = rowInd + dy[i];
                    if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                    else if(closeFriends.includes(mapCopy[newY][newX])) tempCount++;
                }
                if(tempCount > maxFriends) {
                    seatList = [[rowInd,colInd]];
                    maxFriends = tempCount;
                } else if(tempCount === maxFriends) {
                    seatList.push([rowInd,colInd]);
                }
            }
        })
    });
    return seatList;
}

function getEmptySeatNum(studentID, map, seatBasedOnFriend) {
    const mapCopy = map.map((curRow) => {
        return curRow.slice();
    })
    let seatList = [];
    let maxEmptySeat = -1;
    seatBasedOnFriend.forEach((coor, ind) => {
        const [rowInd, colInd] = coor;

        let tempCount = 0;
        for(let i = 0; i<4; i++) {
            let newX = colInd + dx[i];
            let newY = rowInd + dy[i];
            if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
            else if(mapCopy[newY][newX] === 0) tempCount++;
        }
        if(tempCount > maxEmptySeat) {
            seatList = [[rowInd,colInd]];
            maxEmptySeat = tempCount;
        } else if(tempCount === maxEmptySeat) {
            seatList.push([rowInd,colInd]);
        }
    })

    return seatList;
}

function getSatisfaction(map, storeFriend) {
    let totalScore = 0;
    map.forEach((curRow, rowInd) => {
        curRow.forEach((curElement, colInd) => {
            let friendList = storeFriend.get(curElement);
            let tempCount = 0;
            for(let i = 0; i<4; i++) {
                let newX = colInd + dx[i];
                let newY = rowInd + dy[i];
                if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
                else if(friendList.includes(map[newY][newX])) tempCount++;
            }
            totalScore += (tempCount === 0)? 0 :
                (tempCount === 1)? 1 :
                (tempCount === 2)? 10:
                (tempCount === 3)? 100: 1000;
        })
    })
    return totalScore;
}

let storeFriend = new Map();

input.slice(1).forEach((curRow) => {
    const studentID = parseInt(curRow.split(" ")[0]);
    const closeFriends = curRow.split(" ").filter((a, ind) => (ind >=1)).map(a => parseInt(a));
    storeFriend.set(studentID, closeFriends);

    const seatBasedOnFriend = getCloseStudentNum(studentID, closeFriends, map);
    if(seatBasedOnFriend.length === 1) {
        const [rowInd, colInd] = seatBasedOnFriend[0];
        map[rowInd][colInd] = studentID;
        return;
    } else {
        const seatBasedOnEmptySeat = getEmptySeatNum(studentID, map, seatBasedOnFriend);
        if(seatBasedOnEmptySeat.length === 1) {
            const [rowInd, colInd] = seatBasedOnEmptySeat[0];
            map[rowInd][colInd] = studentID;
            return;
        } else {
            const [rowInd, colInd] = seatBasedOnEmptySeat.sort((a,b) => {
                if(a[0] === b[0]) return a[1]-b[1];
                else return a[0]-b[0];
            })[0]
            map[rowInd][colInd] = studentID;
            return;
        }
    }
})

console.log(getSatisfaction(map, storeFriend));