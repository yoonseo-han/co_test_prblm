package Array.Baekjoon;

import java.util.Scanner;

class Solution {
    public static void merge(int [] inputArray, int l, int mid, int r) {
        //2 Arrays
        int [] leftArray = new int[mid-l+1];
        int [] rightArray = new int[r-mid];

        for(int i=0; i<leftArray.length; i++) 
            leftArray[i] = inputArray[i+l];
        for(int i=0; i<rightArray.length; i++)
            rightArray[i] = inputArray[i+mid+1];

        //Index to track for each array
        int i=0; 
        int j=0;
        int k=0;
        //Merge process
        for(k=l; k<=r; k++) {
            //Break if one of index reaches end
            if(i>=mid-l+1 || j>=r-mid) break;
            if(leftArray[i] < rightArray[j]) {
                inputArray[k] = leftArray[i];
                i++;
            }
            else {
                inputArray[k] = rightArray[j];
                j++;
            }
        }
        //Add the remaining array on right array
        if(i>=mid-l+1) {
            while(k<=r) {
                inputArray[k] = rightArray[j];
                k++;
                j++;
            }
        }
        //Add remaining arry on left array
        else {
            while(k<=r) {
                inputArray[k] = leftArray[i];
                k++;
                i++;
            }
        }
    }   

    public static void mergeSort(int[] inputArray, int l, int r) {
        //Base case
        if(l==r) return;

        int mid = (l+r)/2;

        mergeSort(inputArray, l, mid);
        mergeSort(inputArray, mid+1, r);
        merge(inputArray, l, mid, r);
    }
    public static void main(String strs[]) {
        try (Scanner myInput = new Scanner(System.in)) {
            int size = myInput.nextInt();

            int [] inputArray = new int[size];

            //Receive input
            for(int i = 0; i<size; i++) {
                inputArray[i] = myInput.nextInt();
            }

            //USe merge sort for sorting
            mergeSort(inputArray, 0, size-1);

            //Print result
            for(int i: inputArray) {
                System.out.println(i);
            }
        }
    }
}