package boj.boj_6236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참조: https://lotuslee.tistory.com/57
public class Main {

    private static int n;
    private static int m;
    private static int sum = 0;
    private static int[] values;
    private static int max = -100_000;

    public static void main(String[] args) throws Exception {
        n = input.getInteger();
        m = input.getInteger();

        values = new int[n];

        for (int index = 0; index < n; index++) {
            values[index] = input.getInteger();
            max = Math.max(max, values[index]);
            sum += values[index];
        }
        System.out.println(binSearch());
    }

    public static int binSearch() {
        int lPointer = max;
        int rPointer = sum;

        while (lPointer <= rPointer) {
            int mid = (lPointer + rPointer) / 2;
            int count = 1;
            int money = mid;
            for (int index = 0; index < n; index++) {
                if (values[index] > money) {
                    money = mid;
                    count++;
                }
                money = money - values[index];
            }

            if (count > m)
                lPointer = mid + 1;
            else
                rPointer = mid - 1;
        }
        return lPointer;
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
