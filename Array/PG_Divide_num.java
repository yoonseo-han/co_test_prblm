//https://school.programmers.co.kr/learn/courses/30/lessons/135807

import java.util.*;

class Solution {
    public static Vector<Integer> getDivNum(int [] arr) {
        Vector<Integer> result = new Vector<Integer>();
        for(int i=arr[0]; i>=2; i--) {
            for(int j = 0; j<arr.length; j++) {
                //If divisor of whole array
                if(arr[j] % i !=0) break;
                if(j==arr.length-1) result.add(i);
            }
        }
        return result;
    }

    public static int getLargestDiv(Vector<Integer> curList, int[] arr) { 
        for(int i: curList) {
            for(int j = 0; j<arr.length; j++) {
                if(arr[j]%i == 0) break;
                if(j==arr.length-1) return i;
            }
        }
        return 0;
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        Vector<Integer> divIntA = new Vector<>();
        Vector<Integer> divIntB = new Vector<>();
        divIntA = getDivNum(arrayA);
        divIntB = getDivNum(arrayB);

        int answerA = getLargestDiv(divIntA, arrayB);
        int answerB = getLargestDiv(divIntB, arrayA);

        answer = Math.max(answerA, answerB);

        return answer;
    }

    public static void main(String[] args) {
        int[] arrayA = {10,21};
        int[] arrayB = {5,17};

        System.out.println(solution(arrayA, arrayB));
    }
}