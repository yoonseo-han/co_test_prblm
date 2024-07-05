//https://school.programmers.co.kr/learn/courses/30/lessons/92344

function solution(board, skill) {
    const n = board.length;
    const m = board[0].length;

    // Create a difference array
    //const diff = Array.from({ length: n + 1 }, () => Array(m + 1).fill(0));
    const diff = new Array(n+1).fill(0).map(() => Array(m+1).fill(0));

    // Apply the skills to the difference array
    skill.forEach(([type, r1, c1, r2, c2, degree]) => {
        const effect = type === 1 ? -degree : degree;
        diff[r1][c1] += effect;
        if (r2 + 1 < n) diff[r2 + 1][c1] -= effect;
        if (c2 + 1 < m) diff[r1][c2 + 1] -= effect;
        if (r2 + 1 < n && c2 + 1 < m) diff[r2 + 1][c2 + 1] += effect;
    });

    // Apply the prefix sums to the difference array
    for (let i = 0; i < n; i++) {
        for (let j = 1; j < m; j++) {
            diff[i][j] += diff[i][j - 1];
        }
    }
    for (let j = 0; j < m; j++) {
        for (let i = 1; i < n; i++) {
            diff[i][j] += diff[i - 1][j];
        }
    }

    // Update the original board using the difference array
    let answer = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            board[i][j] += diff[i][j];
            if (board[i][j] > 0) {
                answer++;
            }
        }
    }

    return answer;
}
