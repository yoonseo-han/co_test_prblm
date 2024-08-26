import java.util.*;

class Solution {
    public static int backtracking(int[][] ability, boolean[] visited, int sportID, int curSum) {
        if(sportID == ability[0].length) return curSum;
        
        int maxSum = curSum; // Use a local variable to keep track of the maximum su
        for(int i=0; i<visited.length; i++) {
            if(visited[i]) continue;
            else {
                visited[i] = true;
                int newSum = backtracking(ability, visited, sportID + 1, curSum + ability[i][sportID]);
                maxSum = Math.max(maxSum, newSum);
                visited[i] = false;
            }
        }
        return maxSum;
    }
    
    public static int solution(int[][] ability) {
        int answer = 0;
        
        // ArrayList<Person> curStore = new ArrayList<>();
        // int curID = 0;
        int numPpl = ability.length;
        // for(int[] curArr : ability) {
        //     Person curPerson = new Person(curID++);
        //     for(int i = 0; i<numSport; i++) {
        //         curPerson.sportLvl.add(curArr[i]);
        //     }
        // }
        boolean[] visited = new boolean[numPpl];
        answer = backtracking(ability, visited, 0, 0);
        
        
        return answer;
    }
}

class Person {
    int id;
    List<Integer> sportLvl;
    public Person(int id) {
        this.id = id;
        sportLvl = new ArrayList<Integer>();
    }
}
