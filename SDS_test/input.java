package SDS_test;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        // scanner 선언
        Scanner scanner = new Scanner(System.in);

        // int TC = scanner.nextInt();

        // System.out.println("Number of Test cases: " + TC);

        while (scanner.hasNextLine()) {
            String curStr = scanner.nextLine();
            String [] strArray = curStr.split(" ");
            System.out.println(strArray[0]);
            System.out.println(strArray[1]);
            int curNum = Integer.parseInt(strArray[1]);
            System.out.println(curNum + 3);
        }
    }
}