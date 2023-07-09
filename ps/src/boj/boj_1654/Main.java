package boj.boj_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int k;
    private static int n;
    private static int max = 0;
    private static int[] lines;

    public static void main(String[] args) throws Exception {
        k = input.getInteger();
        n = input.getInteger();
        lines = new int[k];

        for (int index = 0; index < k; index++) {
            int line = input.getInteger();
            lines[index] = line;
            max = Math.max(max, line);
        }

        Arrays.sort(lines);
        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long start = 1;
        long end = max;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            long count = count(mid);
            if (count >= n) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    private static int count(long length) {
        int sum = 0;
        for (long line : lines) {
            sum += (line / length);
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

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }
}
