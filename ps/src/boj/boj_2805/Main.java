package boj.boj_2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static long[] trees;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        int m = input.getInteger();
        trees = new long[n];

        for (int index = 0; index < n; index++) {
            trees[index] = input.getLong();
        }

        Arrays.sort(trees);
        long answer = binarySearch(trees[0], trees[n - 1], m);
        System.out.println(answer);

    }

    private static long binarySearch(long start, long end, int target) {
        long answer = -100_000_000;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = sum(mid);

            if (sum >= target) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    private static long sum(long target) {
        long sum = 0;
        for (long tree : trees) {
            if (tree > target) {
                sum += (tree - target);
            }
        }
        return sum;
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
