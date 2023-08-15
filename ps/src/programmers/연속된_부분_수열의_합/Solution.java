package programmers.연속된_부분_수열의_합;

public class Solution {

    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int minStart = 0;
        int minEnd = 0;
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        while (start < sequence.length && end < sequence.length || sum >= k) {
            if (sum < k) {
                sum += sequence[end++];
            } else {
                if (sum == k) {
                    if (end - start < minLength) {
                        minLength = end - start;
                        minEnd = end - 1;
                        minStart = start;
                    }
                }
                sum -= sequence[start++];
            }
        }
        return new int[]{minStart, minEnd};
    }
}
