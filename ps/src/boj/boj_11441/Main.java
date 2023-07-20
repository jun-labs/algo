package boj.boj_11441;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    private static int[] dp;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        numbers = new int[n + 1];
        dp = new int[n + 1];

        for (int index = 1; index <= n; index++) {
            numbers[index] = input.getInteger();
            dp[index] = dp[index - 1] + numbers[index];
        }

        int m = input.getInteger();
        for (int index = 0; index < m; index++) {
            int start = input.getInteger();
            int end = input.getInteger();

            int value = dp[end] - dp[start - 1];
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
