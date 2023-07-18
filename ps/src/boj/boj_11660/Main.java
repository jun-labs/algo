package boj.boj_11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] square;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        int m = input.getInteger();
        square = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                square[x][y] = input.getInteger();
            }
        }

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1] + square[x][y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < m; index++) {
            int x1 = input.getInteger();
            int y1 = input.getInteger();
            int x2 = input.getInteger();
            int y2 = input.getInteger();

            int value = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            sb.append(value)
                    .append("\n");
        }
        System.out.println(sb);
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
