import java.util.*;

class Solution {

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;

        int answer = 0;
        int cacheFill = 0;
        LinkedHashMap<String, Integer> tempStore = new LinkedHashMap()<>();

        for (int i = 0; i < cities.length; i++) {
            String curCity = cities[i].toLowerCase();
            
            if(tempStore.containsKey(curCity)) {
                answer++;
                tempStore.remove(curCity);
                tempStore.put(curCity, 0);
            } else {
                if (cache.size() >= cacheSize) {
                    Iterator<String> it = cache.keySet().iterator();
                    it.next();
                    it.remove();
                }
                cache.put(city, null);
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
        int cacheSize = 3;
        System.out.println(solution(cacheSize, cities));2
    }
}