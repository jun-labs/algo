package programmers.보석_쇼핑;

import static java.util.stream.Collectors.toSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<String, Integer> gemMap = new HashMap<>();
    private int totalCount;
    private int start = 0;
    private int end = 0;
    private int left = 0;
    private int right = 0;

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = solution.solution(gems);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public int[] solution(String[] gems) {
        totalCount = Arrays.stream(gems)
            .collect(toSet())
            .size();

        int distance = 100_000;
        while (true) {
            if (gemMap.size() >= totalCount) {
                String gem = gems[left];
                gemMap.put(gem, gemMap.getOrDefault(gem, 0) - 1);
                if (gemMap.get(gem) <= 0) {
                    gemMap.remove(gem);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                String gem = gems[right];
                gemMap.put(gem, gemMap.getOrDefault(gem, 0) + 1);
                right++;
            }
            if (gemMap.size() == totalCount) {
                if (distance > (right - left)) {
                    start = left + 1;
                    end = right;
                    distance = right - left;
                }
            }
        }
        return new int[]{start, end};
    }
}
