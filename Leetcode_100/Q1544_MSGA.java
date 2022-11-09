package Leetcode_100;


class Solution {
    public static String makeGood(String s) {

        int count = 0;
        while(true) {
            count = 0;
            for(int i=0; i<s.length()-1; i++) {
                //Update the string to store as individual character arrays
                char[] ch = s.toCharArray();
                //If inappropriate then remove both i and i+1
                if(ch[i]-ch[i+1]==32 ||ch[i]-ch[i+1]==-32 ) {
                    //Erase the following i, i+1 from the original string
                    s = s.substring(0, i) + s.substring(i+2);
                    //Increment count
                    count++;
                }
            }
            if(count == 0) {
                break;
            }
            //s = s.substring(0, 1);
        }
        return s;
    }
    public static void main(String[] args){
        String output = makeGood("leEeetcode");
        System.out.println(output);
    }
}