package boj.boj_2512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Input input = new Input();
    private static int[] prices;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        prices = new int[n];

        long start = 0;
        long end = 0;

        for (int index = 0; index < n; index++) {
            prices[index] = input.getInteger();
            end = Math.max(prices[index], end);
        }

        int budget = input.getInteger();

        long mid = -1;
        long result = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            long sum = 0;
            for (int index = 0; index < n; index++) {
                if (prices[index] > mid) {
                    sum += mid;
                } else {
                    sum += prices[index];
                }
            }
            if (sum <= budget) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
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

        public long getLong() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Long.parseLong(st.nextToken());
        }
    }
}
