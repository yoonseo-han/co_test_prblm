import java.util.*;

class Solution {
    public int getHead(String[] tempStore, String curString) {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < curString.length(); i++) {
            char curChar = curString.charAt(i);
            if (!Character.isLetter(curChar) && curChar != ' ' && curChar != '.' && curChar != '-') {
                tempStore[0] = tempString.toString().toLowerCase();
                return i;
            }
            tempString.append(curChar);
        }
        tempStore[0] = tempString.toString().toLowerCase();
        return curString.length();
    }

    public int getNumber(int startPos, String curString, String[] tempStore) {
        StringBuilder tempString = new StringBuilder();
        int i = startPos;

        while (i < curString.length() && Character.isDigit(curString.charAt(i)) && tempString.length() < 5) {
            tempString.append(curString.charAt(i));
            i++;
        }

        tempStore[1] = tempString.toString();
        return i;
    }

    public String[] solution(String[] files) {
        List<String[]> listStore = new ArrayList<>();
        int idx = 0;

        for (String curString : files) {
            String[] tempStore = new String[4]; // [HEAD, NUMBER, INDEX, 원본 파일명]
            int numberStart = getHead(tempStore, curString);
            getNumber(numberStart, curString, tempStore);
            tempStore[2] = Integer.toString(idx++);
            tempStore[3] = curString;
            listStore.add(tempStore);
        }

        listStore.sort((a, b) -> {
            int headCompare = a[0].compareTo(b[0]);
            if (headCompare != 0)
                return headCompare;

            int numA = Integer.parseInt(a[1]);
            int numB = Integer.parseInt(b[1]);
            if (numA != numB)
                return numA - numB;

            return Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));
        });

        return listStore.stream().map(x -> x[3]).toArray(String[]::new);
    }
}
