package boj.boj_2776;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    private static int[] targets;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = input.getInteger();

        while (t-- > 0) {
            int n = input.getInteger();
            numbers = new int[n];

            for (int index = 0; index < n; index++) {
                numbers[index] = input.getInteger();
            }

            Arrays.sort(numbers);

            int m = input.getInteger();

            targets = new int[m];
            for (int index = 0; index < m; index++) {
                targets[index] = input.getInteger();
                boolean result = binarySearch(targets[index]);
                if (result) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int number) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == number) {
                return true;
            } else if (numbers[mid] > number) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
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
