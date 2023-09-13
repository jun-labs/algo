package programmers.정수_삼각형;

public class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        int maxRow = triangle.length;
        int maxCol = triangle.length;

        dp[0][0] = triangle[0][0];

        for (int row = 1; row < maxRow; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                if (col == 0) {
                    dp[row][col] = dp[row - 1][col] + triangle[row][col];
                } else {
                    dp[row][col] =
                        Math.max(dp[row - 1][col], dp[row - 1][col - 1]) + triangle[row][col];
                }
            }
        }
        for (int index = 0; index < maxCol; index++) {
            answer = Math.max(dp[maxRow - 1][index], answer);
        }
        return answer;
    }
}
