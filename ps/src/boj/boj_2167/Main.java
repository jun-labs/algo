package boj.boj_2167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static long[][] dp;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        int m = input.getInteger();
        map = new int[n + 1][m + 1];
        dp = new long[n + 1][m + 1];

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                map[x][y] = input.getInteger();
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1] + map[x][y];
            }
        }

        int k = input.getInteger();
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < k; index++) {
            int i = input.getInteger();
            int j = input.getInteger();
            int x = input.getInteger();
            int y = input.getInteger();

            long value = dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1];
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

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
