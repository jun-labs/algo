package programmers.입국심사;

import java.util.Arrays;

public class Solution {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long start = 0;
        long end = (long) times[times.length - 1] * n;
        long mid = 0;
        long answer = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            long count = 0;
            for (int time : times) {
                count += (mid / time);
            }

            if (count < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
