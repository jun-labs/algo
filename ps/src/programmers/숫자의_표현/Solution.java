package programmers.숫자의_표현;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            for (int subValue = start; subValue <= n; subValue++) {
                sum += subValue;
                if (sum == n) {
                    answer++;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
