import java.util.*;

class Solution {
    public void generatePermutation(List<List<Integer>> permStore, List<Integer> tempStore, boolean[] visited) {
        if (tempStore.size() == 3) {
            permStore.add(tempStore); 
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) { // Check if index is already visited
                visited[i] = true;
                List<Integer> newTempStore = new ArrayList<>(tempStore); // Copy tempStore
                newTempStore.add(i);
                generatePermutation(permStore, newTempStore, visited);
                visited[i] = false;
            }
        }
    }    
    
    public long calcExpression(List<Integer> precedenceOrder, List<String> opsStore, List<Integer> numStore) {
        List<Long> numList = new ArrayList<>();
        for (int num : numStore) {
            numList.add((long) num);
        }
        List<String> opList = new ArrayList<>(opsStore);
        
        // Define the operator precedence based on the permutation
        String[] operators = {"+", "-", "*"};
        for (int prec : precedenceOrder) {
            String currentOp = operators[prec];
            for (int i = 0; i < opList.size(); ) {
                if (opList.get(i).equals(currentOp)) {
                    // Perform the operation on the corresponding numbers
                    long result = 0;
                    if (currentOp.equals("+")) {
                        result = numList.get(i) + numList.get(i + 1);
                    } else if (currentOp.equals("-")) {
                        result = numList.get(i) - numList.get(i + 1);
                    } else if (currentOp.equals("*")) {
                        result = numList.get(i) * numList.get(i + 1);
                    }

                    // Update lists
                    numList.set(i, result);
                    numList.remove(i + 1);
                    opList.remove(i);
                } else {
                    i++;
                }
            }
        }

        // The final result is the only number left
        return Math.abs(numList.get(0));
        
    }
    
    public long solution(String expression) {
        long answer = 0;
        List<Integer> intStore = new ArrayList<>();
        List<String> opsStore = new ArrayList<>();
        
        int idx = 0;
        String tempStore = "";
        while (idx < expression.length()) {
            char curChar = expression.charAt(idx++);
            if (curChar == '*' || curChar == '-' || curChar == '+') {
                int curNum = Integer.parseInt(tempStore);
                intStore.add(curNum);
                opsStore.add(Character.toString(curChar));
                tempStore = "";
            } else {
                tempStore += curChar;
            }
        }
        
        // Add the last number to intStore
        if (!tempStore.isEmpty()) {
            intStore.add(Integer.parseInt(tempStore));
        }
        
        List<List<Integer>> storePermutation = new ArrayList<>();
        generatePermutation(storePermutation, new ArrayList<>(), new boolean[3]);
        
        for(List<Integer> curPerm: storePermutation) {
            answer = Math.max(answer, calcExpression(curPerm, opsStore, intStore));
        }
        
        return answer;
    }
}