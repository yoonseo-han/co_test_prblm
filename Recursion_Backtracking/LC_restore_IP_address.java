import java.util.*;

class LC_restore_IP_address {
    public static String generateString(List<String> tempStore) {
        String result = "";

        for(int i = 0; i<4; i++) {
            result += tempStore.get(i);
            if(i!= 3) result += ".";
        }
        return result;
    }
    public static void backtracking(int curPosition, List<String> tempStore, List<String> result, String s) {
        // Condition for success
        if(tempStore.size() == 4 && curPosition == s.length()) {
            result.add(generateString(tempStore));
        }

        if((tempStore.size() == 4 && curPosition < s.length()) || (tempStore.size() < 4 && curPosition == s.length())) {
            return;
        }

        for(int i = 1; i<=3; i++) {
            // Bounds check
            if(curPosition + i > s.length()) break; 

            // Generate new string for current 
            String tempString = s.substring(curPosition, curPosition + i);
            // Condition for inappropriate string : Contains trailing 0 or is larger than 255
            int lastInt = Integer.parseInt(tempString);
            if(lastInt > 255 || (tempString.charAt(0) == '0' && tempString.length() > 1)) {
                continue;
            }
            tempStore.add(tempString);
            backtracking(curPosition + i, tempStore, result, s);
            tempStore.remove(tempStore.size()-1);
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> resultList = new ArrayList<>();
        backtracking(0, new ArrayList<String>(), resultList, s);
        return resultList;
    }
    public static void main(String[] args) {
        String s = "25525511135";
        for (String curString: restoreIpAddresses(s)) {
            System.out.println(curString);
        }
    }
}