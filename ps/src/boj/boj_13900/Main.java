package boj.boj_13900;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    private static int[] sum;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        numbers = new int[n + 1];
        sum = new int[n + 1];

        for (int index = 1; index <= n; index++) {
            numbers[index] = input.getInteger();
            sum[index] = sum[index - 1] + numbers[index];
        }

        long answer = 0;
        for (int index = 2; index <= n; index++) {
            answer += (long) (numbers[index]) * sum[index - 1];
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
    }
}
