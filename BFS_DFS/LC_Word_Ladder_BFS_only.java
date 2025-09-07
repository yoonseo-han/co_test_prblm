import java.util.*;

class Solution {
    public boolean canReachWord(String curWord, String lastWord) {
        int count = 0;
        for(int i = 0; i < curWord.length(); i++) {
            if(curWord.charAt(i) != lastWord.charAt(i)) {
                count++;
                if(count > 1) return false; // early pruning
            }
        }
        return count == 1;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Queue<List<String>> tempQueue = new LinkedList<>();
        boolean foundEndWord = false;
        Set<String> globalVisited = new HashSet<>();

        List<String> startPath = new ArrayList<>();
        startPath.add(beginWord);
        tempQueue.add(startPath);

        while(!tempQueue.isEmpty()) {
            if(foundEndWord) break;

            // Traverse current queue -> current level
            int n = tempQueue.size();
            Set<String> curLevelVisited = new HashSet<>();

            for(int i = 0; i<n; i++) {
                List<String> curList = tempQueue.poll();
                String lastWord = curList.get(curList.size() - 1);

                for(String curWord: wordList) {
                    if(canReachWord(lastWord, curWord) && !globalVisited.contains(curWord)) {
                        curLevelVisited.add(curWord);
                        List<String> tempList = new ArrayList<>(curList); // copy current path
                        tempList.add(curWord);                            // append new word
                        tempQueue.add(tempList);

                        if(curWord.equals(endWord)) {
                            foundEndWord = true;
                        }
                    }
                }
            }

            // Add curLevelVisited to global Set
            for(String curString: curLevelVisited) globalVisited.add(curString);

            // If reach final level and path is appropriate -> store in result
            for(List<String> path : tempQueue) {
                if(path.get(path.size() - 1).equals(endWord)) {
                    result.add(path);
                }
            }
        }
        return result;
    }
}