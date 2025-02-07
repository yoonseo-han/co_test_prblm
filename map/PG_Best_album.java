import java.util.*;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> storeGenrePlay = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            storeGenrePlay.put(genres[i], storeGenrePlay.getOrDefault(genres[i], 0) + plays[i]);

            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new int[] { i, plays[i] });
        }

        // Sort both maps
        List<Map.Entry<String, Integer>> sortedGenre = new ArrayList<>(storeGenrePlay.entrySet());
        sortedGenre.sort((a, b) -> b.getValue() - a.getValue());

        // Sort each songs in genre
        List<Integer> bestAlbum = new ArrayList<>();
        for (Map.Entry<String, Integer> genreInfo : sortedGenre) {
            String curGenre = genreInfo.getKey();
            List<int[]> songs = genreSongs.get(curGenre);

            // Sort songs based on play, then ID
            songs.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                bestAlbum.add(songs.get(i)[0]);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String strs[]) {
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        for (int i : solution(genres, plays)) {
            System.out.println(i);
        }
    }
}