import java.util.*;

class Solution {
    public static <K, V extends Comparable<V>> K getKeyWithLowestValue(Map<K, V> map) {
        K keyWithMinValue = null;
        V minValue = null;

        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (minValue == null || entry.getValue().compareTo(minValue) < 0) {
                minValue = entry.getValue();
                keyWithMinValue = entry.getKey();
            }
        }
        return keyWithMinValue;
    }

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;

        int answer = 0;
        int cacheFill = 0;
        HashMap<String, Integer> tempStore = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            String curCity = cities[i].toLowerCase();
            if (tempStore.containsKey(curCity)) {
                tempStore.put(curCity, i);
                answer++;
            } else {
                if (tempStore.size() >= cacheSize) {
                    // Have to city with lowest value
                    String removeKey = getKeyWithLowestValue(tempStore);
                    tempStore.remove(removeKey);
                }
                answer += 5;
                tempStore.put(curCity, i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
        int cacheSize = 3;
        System.out.println(solution(cacheSize, cities));
    }
}