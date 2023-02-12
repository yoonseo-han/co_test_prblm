package Leetcode_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;
import java.util.List;

class Solution {
    public static int[][] merge(int[][] intervals) {
        //Sort array from starting time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        //List to store result
        List<int[]> resultList = new ArrayList<>();

        for(int[] interval: intervals) {
            //when there is no overlap
            if(resultList.isEmpty() || resultList.get(resultList.size()-1)[1] <interval[0]) {
                resultList.add(interval);
            }
            //When there is overlap, update end time
            else {
                int [] tempInterval = new int[2];
                tempInterval[0] = resultList.get(resultList.size()-1)[0];
                tempInterval[1] = resultList.get(resultList.size()-1)[1] > interval[1]? resultList.get(resultList.size()-1)[1]: interval[1];
                resultList.set(resultList.size()-1, tempInterval);
            }
        }

        //return resultList.toArray(new int[resultList.size()][]);
        int [][] resultArray = new int[resultList.size()][2];
        for(int i=0; i<resultArray.length; i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    public static void main(String strs[]) {
        //Use scanner to receive input
        /*
        Scanner inputArray = new Scanner(System.in);

        System.out.println("Number of intervals : ");
        int inputSize = inputArray.nextInt();

        int [][] inputStore = new int[inputSize][2];

        for(int i=0; i<inputSize; i++) {
            inputStore[i][0] = inputArray.nextInt();
            inputStore[i][1] = inputArray.nextInt();
        }
        */

        int [][] inputStore = {{1,3},{2,6},{8,10},{15,18}};

        merge(inputStore);
    }
}