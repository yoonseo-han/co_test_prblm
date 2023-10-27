package Leetcode_100;

import java.util.*;

class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> tempStore = new Stack<>();

        for (int i = 0; i < n; i++) {
            //For positive asteroids: Push to stack
            if (asteroids[i] > 0 || tempStore.isEmpty()) {
                tempStore.push(asteroids[i]);
            } 
            //For negative asteroids
            else {
                while (!tempStore.isEmpty() && tempStore.peek() > 0 && tempStore.peek() < Math.abs(asteroids[i])) {
                    // If negative asteroid is bigger: remove the asteroid stored in stack
                    tempStore.pop();
                }
                if (!tempStore.isEmpty() && tempStore.peek() == Math.abs(asteroids[i])) {
                    //Both disappear if have equal size
                    tempStore.pop();
                } else {
                    if (tempStore.isEmpty() || tempStore.peek() < 0) {
                        // both negative: add to stack
                        tempStore.push(asteroids[i]);
                    }
                }
            }
        }

        int[] res = new int[tempStore.size()];
        for (int i = tempStore.size() - 1; i >= 0; i--) {
            res[i] = tempStore.pop();
        }
        return res;
    }
    public static void main(String strs[]) {
        int [] asteroids = {5,10,-5};
        int [] result = asteroidCollision(asteroids);
        for(int i: result) System.out.println(i);
    }
}