package boj.boj_2003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long[] numbers;
    private static long[] dp;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        long m = input.getLong();
        int answer = 0;

        numbers = new long[n + 1];
        dp = new long[n + 1];

        for (int index = 1; index <= n; index++) {
            numbers[index] = input.getInteger();
            dp[index] = dp[index - 1] + numbers[index];
            if (dp[index] == m) answer++;
        }

        for (int x = 1; x < n; x++) {
            for (int y = x + 1; y <= n; y++) {
                if (dp[y] - dp[x] == m) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public long getLong() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Long.parseLong(st.nextToken());
        }

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
