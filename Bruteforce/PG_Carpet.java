package Bruteforce;

class Solution {
    public static int[] solution(int brown, int yellow) {
        int totalNum = brown + yellow;
        int[] answer = new int[2];

        for(int width = (totalNum-1); width>0; width--) {
            //If cant be divided
            if(totalNum%width != 0) continue;

            int height = totalNum/width;
            int numOfYellow = (width-2)*(height-2);
            int numOfBrown = totalNum - numOfYellow;

            if(numOfYellow == yellow && numOfBrown == brown) {
                //Insert
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }

    public static void main(String strs[]) {
        int brown = 10;
        int yellow = 2;
        System.out.println(solution(brown, yellow));
    }
}