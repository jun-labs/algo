package boj.boj_2293;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Input input = new Input();
    private static int[] numbers;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        int target = input.getInteger();

        numbers = new int[n + 1];
        dp = new int[target + 1];

        dp[0] = 1;
        for (int x = 1; x <= n; x++) {
            numbers[x] = input.getInteger();
            for (int y = numbers[x]; y <= target; y++) {
                dp[y] += dp[y - numbers[x]];
            }
        }
        System.out.println(dp[target]);
    }

    static class Input {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
    }

}
