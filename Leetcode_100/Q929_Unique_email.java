package Leetcode_100;

import java.util.*;

class Solution {
    public static int numUniqueEmails(String[] emails) {
        //String comparison required: Object1.equals(Object2)
        
        //Set to store the current email addresses
        Set <String> tempStore = new HashSet<String>();
        int count = 0;

        for(String email: emails) {
            int atIndex = email.indexOf("@");
            int plusIndex= email.indexOf("+");

            String tempString = new String();

            //First sort string based on + index and only the domain part
            if(plusIndex>=0) tempString = email.substring(0,plusIndex);
            else tempString = email.substring(0, atIndex);

            //Then ignore all .
            tempString = tempString.replace(".", "") + email.substring(atIndex);

            if(!tempStore.contains(tempString)) {
                tempStore.add(tempString);
                count++;
            }
        }

        return count;
    }

    public static void main(String strs[]) {
        String [] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}