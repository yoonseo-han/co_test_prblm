//https://school.programmers.co.kr/learn/courses/30/lessons/60059

class Solution {
    public void rotate90(int[][] arr) {
        int N = arr.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[N - j - 1][i];
                arr[N - j - 1][i] = arr[N - i - 1][N - j - 1];
                arr[N - i - 1][N - j - 1] = arr[j][N - i - 1];
                arr[j][N - i - 1] = temp;
            }
        }
    }

    public boolean isMatched(int[][] key, int[][] lock, int startX, int startY) {
        int keySize = key.length;
        int lockSize = lock.length;

        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                int keyI = i - startY;
                int keyJ = j - startX;
                int keyValue = 0;

                if (keyI >= 0 && keyI < keySize && keyJ >= 0 && keyJ < keySize) {
                    keyValue = key[keyI][keyJ];
                }

                if (lock[i][j] + keyValue != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;

        for (int rot = 0; rot < 4; rot++) {
            for (int i = -keySize + 1; i < lockSize; i++) {
                for (int j = -keySize + 1; j < lockSize; j++) {
                    if (isMatched(key, lock, j, i)) {
                        return true;
                    }
                }
            }
            rotate90(key);
        }

        return false;
    }
}
