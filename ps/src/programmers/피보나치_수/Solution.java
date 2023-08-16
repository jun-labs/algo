package programmers.피보나치_수;

class Solution {

    private static final int DIVISION_NUMBER = 1234567;
    private int[] dp;

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
    }

    public int solution(int n) {
        if (n == 2) {
            return 1;
        }
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int index = 3; index <= n; index++) {
            dp[index] = (dp[index - 1] + dp[index - 2]) % DIVISION_NUMBER;
        }
        return dp[n];
    }
}
