package boj.boj_2559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    private static int[] sum;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        int k = input.getInteger();
        numbers = new int[n + 1];
        sum = new int[n + 1];

        for (int index = 1; index <= n; index++) {
            numbers[index] = input.getInteger();
            sum[index] = sum[index - 1] + numbers[index];
        }

        int max = Integer.MIN_VALUE;
        for (int index = k; index <= n; index++) {
            int value = sum[index] - sum[index - k];
            max = Math.max(max, value);
        }
        System.out.println(max);
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
    }
}
