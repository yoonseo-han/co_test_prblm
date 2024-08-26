//https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java

import java.util.*;

class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            //Negates any character that is not included in skill: Regular expression pattern
            //System.out.println(it.next().replaceAll("[^" + skill + "]", ""));
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
    public static void main(String [] strs) {
        String skill = "CBD";
        String [] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
}