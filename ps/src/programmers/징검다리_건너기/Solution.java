package programmers.징검다리_건너기;

public class Solution {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int end = 200_000_000;
        int start = 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isCrossable(stones, k, mid)) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    private boolean isCrossable(int[] stones, int limit, int friendCount) {
        int impossibleCount = 0;
        for (int stone : stones) {
            if (stone - friendCount < 0) {
                impossibleCount++;
            } else {
                impossibleCount = 0;
            }

            if (impossibleCount == limit) {
                return false;
            }
        }
        return true;
    }
}
