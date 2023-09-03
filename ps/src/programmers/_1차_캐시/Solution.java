package programmers._1차_캐시;

import java.util.LinkedHashSet;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        LinkedHashSet<String> cache = new LinkedHashSet<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(cache.iterator().next());
                }
                cache.add(city);
            }
        }
        return answer;
    }
}
