class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;

        int leftIdx = 0;
        int rightIdx = 0;
        int writeIdx = 0;
        int n = chars.length;

        char curChar = chars[0];
        while (rightIdx < n) {
            while (rightIdx < n && chars[rightIdx] == chars[leftIdx]) {
                rightIdx++;
            }
            int curLength = rightIdx - leftIdx;
            chars[writeIdx++] = chars[leftIdx];
            if (curLength > 1) {
                for (char c : String.valueOf(curLength).toCharArray()) {
                    chars[writeIdx++] = c;
                }
            }

            leftIdx = rightIdx;
        }

        return writeIdx;
    }
}