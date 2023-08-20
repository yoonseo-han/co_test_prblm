package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //Able to track whether node has been visited via 1d array
        boolean [] visited = new boolean[rooms.size()];
        Stack<Integer> tempStore = new Stack<>();
        int count = 1;
        visited[0]=true;

        tempStore.push(0);

        while(!tempStore.isEmpty()) {
            //Iterate through all of the keys that current room has
            for(int i : rooms.get(tempStore.pop())) {
                if(visited[i]==false) {
                    visited[i] = true;
                    count++;
                    tempStore.push(i);
                }
            }
        }

        return rooms.size() == count;
    }
    public static void main(String strs[]) {
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();

        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(canVisitAllRooms(rooms));
    }
}