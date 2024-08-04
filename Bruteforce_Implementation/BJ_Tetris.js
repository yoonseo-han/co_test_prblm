//https://www.acmicpc.net/problem/3019
const fs = require("fs");
let input = fs.readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt").toString().trim().split("\n");

function isLevel(start, width, map) {
    let h = map[start];
    for (let i = start + 1; i < start + width; ++i) {
        if (h !== map[i]) return false;
    }
    return true;
}

function solve(width, type, map) {
    let ret = 0;
    if (type === 1) { // 1x4
        // 1 - 1 -> 무조건 됨
        ret += width;

        // 1 - 2
        for (let i = 0; i <= width - 4; ++i) {
            ret += isLevel(i, 4, map) ? 1 : 0;
        }

    } else if (type === 2) { // 정사각형
        // 2 - 1
        for (let i = 0; i <= width - 2; ++i) {
            ret += isLevel(i, 2, map) ? 1 : 0;
        }
    } else if (type === 3) { // 오른쪽을 보고 있는 지그재그
        // 3 - 1
        for (let i = 0; i <= width - 3; ++i) {
            if (map[i] === map[i + 1] && map[i] === map[i + 2] - 1) ret++;
        }

        // 3 - 2
        for (let i = 0; i <= width - 2; ++i) {
            if (map[i] === map[i + 1] + 1) ret++;
        }

    } else if (type === 4) {
        // 4 - 1
        for (let i = 0; i <= width - 3; ++i) {
            if (map[i + 1] === map[i + 2] && map[i] - 1 === map[i + 1]) ret++;
        }

        // 4 - 2
        for (let i = 0; i <= width - 2; ++i) {
            if (map[i] === map[i + 1] - 1) ret++;
        }

    } else if (type === 5) {
        // 5 - 1 ㅗ
        for (let i = 0; i <= width - 3; ++i) {
            ret += isLevel(i, 3, map) ? 1 : 0;
        }

        // 5 - 2 ㅏ
        for (let i = 0; i <= width - 2; ++i) {
            if (map[i] === map[i + 1] - 1) ret++;
        }

        // 5 - 3 ㅜ
        for (let i = 0; i <= width - 3; ++i) {
            if (map[i] === map[i + 2] && map[i + 1] === map[i] - 1) ret++;
        }

        // 5 - 4 ㅓ
        for (let i = 0; i <= width - 2; ++i) {
            if (map[i] === map[i + 1] + 1) ret++;
        }

    } else if (type === 6) {
        // 6 - 1
        for (let i = 0; i <= width - 3; ++i) {
            ret += isLevel(i, 3, map) ? 1 : 0;
        }

        // 6 - 2
        for (let i = 0; i <= width - 2; ++i) {
            ret += isLevel(i, 2, map) ? 1 : 0;
        }

        // 6 - 3
        for (let i = 0; i <= width - 3; ++i) {
            if (map[i] === map[i + 1] - 1 && map[i + 1] === map[i + 2]) ret++;
        }

        // 6 - 4
        for (let i = 0; i <= width - 2; ++i) {
            if (map[i] - 2 === map[i + 1]) ret++;
        }

    } else if (type === 7) {
        // 7 - 1
        for (let i = 0; i <= width - 3; ++i) {
            ret += isLevel(i, 3, map) ? 1 : 0;
        }

        // 7 - 2
        for (let i = 0; i <= width - 2; ++i) {
            ret += isLevel(i, 2, map) ? 1 : 0;
        }

        // 7 - 3
        for (let i = 0; i <= width - 3; ++i) {
            if (map[i] === map[i + 1] && map[i + 1] === map[i + 2] + 1) ret++;
        }

        // 7 - 4
        for (let i = 0; i <= width - 2; ++i) {
            if (map[i] + 2 === map[i + 1]) ret++;
        }

    }

    return ret;
}

let map = input[1].split(" ").map(a => parseInt(a));
let [width, type] = input[0].split(" ").map(a => parseInt(a));

console.log(solve(width, type, map));
