//https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

class Solution {
    int minScore = Integer.MAX_VALUE;
    String[] mineralID = {"diamond", "iron", "stone"};
    
    public int getTired(String gok, String mineral) {
        if(gok.equals("diamond")) return 1;
        else if(gok.equals("iron")) {
            if(mineral.equals("diamond")) return 5;
            else return 1;
        }
        else {
            if(mineral.equals("diamond")) return 25;
            else if(mineral.equals("iron")) return 5;
            else return 1;
        }
    }
    
    public int returnTotalTired(String[] goks, String[] minerals) {
        int totalSum = 0;
        int ind = 0;
        
        for(String curGok: goks) {
            for(int i=0; i<5; i++) {
                if(ind + i >= minerals.length) break;
                totalSum += getTired(curGok, minerals[ind+i]);
            } 
            ind += 5;
        }
        
        return totalSum;
    }
    
    public void generateAllScore(ArrayList<String> curArray, int numOfGok, int[] curStatus, String[] minerals) {
        int totalGok=0;
        for(int i=0; i<3; i++) totalGok += curStatus[i];
        if(curArray.size() == numOfGok || totalGok == 0) {
            minScore = Math.min(minScore, returnTotalTired(curArray.toArray(new String[0]), minerals));
        }
        else {
            for(int i=0; i<curStatus.length; i++) {
                if(curStatus[i] > 0) {
                    curStatus[i]--;
                    curArray.add(mineralID[i]);
                    generateAllScore(curArray, numOfGok, curStatus, minerals);
                    
                    curArray.remove(curArray.size() - 1);
                    curStatus[i]++;
                }
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int numOfGok = minerals.length / 5;
        numOfGok = (minerals.length % 5 == 0) ? numOfGok : numOfGok + 1;
        System.out.println(numOfGok);
        ArrayList<String> curArray = new ArrayList<>();
        
        generateAllScore(curArray, numOfGok, picks, minerals);
        
        return minScore;
    }
}
