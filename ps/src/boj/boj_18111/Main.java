package boj.boj_18111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static Input input = new Input();
    private static int[][] map;
    private static int size;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        int m = input.getInteger();
        int b = input.getInteger();
        size = n * m;
        map = new int[n][m];

        int time = Integer.MAX_VALUE;
        int height = 0;
        int max = -100_000;
        int min = 100_000;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                map[row][col] = input.getInteger();
                max = Math.max(max, map[row][col]);
                min = Math.min(min, map[row][col]);
            }
        }

        for (int tempHeight = max; tempHeight >= min; tempHeight--) {
            int tempTime = 0;
            int block = b;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (map[row][col] > tempHeight) {
                        block += (map[row][col] - tempHeight);
                        tempTime += (2 * (map[row][col] - tempHeight));
                    } else if (map[row][col] < tempHeight) {
                        block -= (tempHeight - map[row][col]);
                        tempTime += (tempHeight - map[row][col]);
                    }
                }
            }
            if (block >= 0 && time > tempTime) {
                height = tempHeight;
                time = tempTime;
            }
        }
        System.out.println(time + " " + height);
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
