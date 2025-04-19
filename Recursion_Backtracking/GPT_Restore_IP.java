import java.util.*;

class Solution {
    public static List<String> restoreIpAddresses(String curString) {
        List<String> result = new ArrayList<>();
        backtracking(result, curString, new ArrayList<>(), 0);
        return result;
    }

    public static void backtracking(List<String> result, String ipString, List<String> curPath, int curPos) {
        if (curPath.size() == 4) {
            if (curPos == ipString.length()) {
                result.add(String.join(curPath, "."));
            }
            return;
        }

        // Try every path from 1 to 3 from current position
        for (int i = 1; i <= 3; i++) {
            if (curPos + i > ipString.length())
                break;

            String partString = ipString.substring(curPos, curPos + i);

            curPath.add(partString);
            backtracking(result, ipString, curPath, curPos + i);
            curPath.remove(curPath.size() - 1);
        }
    }

    public static void main(String strs[]) {
        String s = "25525511135";
        List<String> ips = restoreIpAddresses(s);
        System.out.println("All valid IPs: " + ips);
    }
}