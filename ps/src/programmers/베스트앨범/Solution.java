package programmers.베스트앨범;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {

    private final Map<String, Integer> countMap = new HashMap<>();
    private final Map<String, List<Album>> albums = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String[] generes = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Solution solution = new Solution();
        System.out.println(solution.solution(generes, plays));
    }

    public int[] solution(String[] genres, int[] plays) {
        for (int index = 0; index < genres.length; index++) {
            String genre = genres[index];
            Integer count = countMap.getOrDefault(genre, 0);
            countMap.put(genre, count + plays[index]);

            List<Album> classifiedAlbum = albums.getOrDefault(genre, new ArrayList<>());
            classifiedAlbum.add(new Album(index, genres[index], plays[index]));
            albums.put(genre, classifiedAlbum);
        }

        List<Entry<String, Integer>> sortedEntries = new ArrayList<>(countMap.entrySet());
        sortedEntries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        List<Album> answer = new ArrayList<>();

        for (Entry<String, Integer> entry : sortedEntries) {
            List<Album> classifiedAlbum = albums.get(entry.getKey());

            Collections.sort(classifiedAlbum);
            List<Album> album = classifiedAlbum
                .stream()
                .limit(2)
                .collect(Collectors.toList());
            answer.addAll(album);
        }
        return answer.stream()
            .map(x -> x.index)
            .mapToInt(Integer::intValue).toArray();
    }

    static class Album implements Comparable<Album> {

        int index;
        String name;
        int count;

        public Album(int index, String name, int count) {
            this.index = index;
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Album o) {
            return o.count - this.count;
        }
    }
}
