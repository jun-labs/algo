package programmers.신고_결과_받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private Map<String, Integer> idMap = new HashMap<>();
    private Map<String, HashSet<String>> map = new HashMap<>();
    private int[] answer;

    public int[] solution(String[] id_list, String[] report, int k) {
        answer = new int[id_list.length];

        for (int index = 0; index < id_list.length; index++) {
            idMap.put(id_list[index], index);
            map.put(id_list[index], new HashSet<>());
        }

        for (String r : report) {
            String[] str = r.split(" ");
            map.get(str[1]).add(str[0]);
        }

        for (int index = 0; index < id_list.length; index++) {
            Set<String> set = map.get(id_list[index]);
            if (set.size() >= k) {
                for (String userId : set) {
                    answer[idMap.get(userId)]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.solution(id_list, report, k));
    }
}
