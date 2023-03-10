package Superlabs;

import javax.print.attribute.standard.JobHoldUntil;

class Solution {
    public static int getNumOfDuplicate(String s1, String s2, int limit) {
        int answer = 0;
        for(int i= limit; i>=0; i--) {
            String tempS1 = s1.substring(s1.length()-i);
            String tempS2 = s2.substring(0,i);

            if(tempS1.equals(tempS2)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static String joinString(String s1, String s2, int numOfDuplicate) {

        int lengthOfResult = s1.length() + s2.length() - numOfDuplicate;
        char[] resultArray = new char[lengthOfResult];

        int j=0;
        for(int i=0; i<lengthOfResult; i++) {
            if(i<s1.length()) resultArray[i] = s1.charAt(i);
            else {
                resultArray[i] = s2.charAt(j + numOfDuplicate);
                j++;
            }
        }
        return String.valueOf(resultArray);
    }

    public static String solution(String s1, String s2) {
        String answer = "";

        int maxDuplicate = (s1.length() > s2.length())? s2.length() : s1.length();

        int firstCase = getNumOfDuplicate(s1, s2, maxDuplicate);
        int secondCase = getNumOfDuplicate(s2, s1, maxDuplicate);

        System.out.println(firstCase);
        System.out.println(secondCase);
        
        if(firstCase > secondCase) answer = joinString(s1, s2, firstCase);
        else if(firstCase < secondCase) answer = joinString(s2, s1, secondCase);
        else {
            String firstResult = joinString(s1, s2, firstCase);
            String secondResult = joinString(s2, s1, secondCase);
            answer = firstResult.compareTo(secondResult) < 0 ? firstResult : secondResult;
        }
        //else answer = joinString(s1, s2, firstCase).compareTo(joinString(s2, s1, secondCase)) < 0? : joinString(s1, s2, firstCase) : joinString(s1, s2, firstCase);

        return answer;
    }

    public static void main(String strs[]) {
        String s1 = "aaa";
        String s2 = "aaab";

        System.out.println(solution(s1, s2));
    }
}