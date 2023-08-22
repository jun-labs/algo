package boj.boj_14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참조: https://minhamina.tistory.com/133
class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static int X;
    private static int Y;
    private static int[][] map;
    private static int[] dice;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static Input input = new Input();

    public static void main(String[] args) throws Exception {
        N = input.getInteger();
        M = input.getInteger();
        X = input.getInteger();
        Y = input.getInteger();
        int k = input.getInteger();

        map = new int[N][M];
        dice = new int[6];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                map[x][y] = input.getInteger();
            }
        }

        for (int index = 0; index < k; index++) {
            int direction = input.getInteger();
            roll(direction - 1);
        }
        System.out.println(sb);
    }

    static void roll(int direction) {
        int nextX = X + dx[direction];
        int nextY = Y + dy[direction];

        if (imMoveable(nextX, nextY)) {
            return;
        }

        int tmp = dice[5];
        switch (direction) {
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;

            default:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
        }

        sb.append(dice[0]).append("\n");

        X = nextX;
        Y = nextY;

        if (map[X][Y] == 0) {
            map[X][Y] = dice[5];
        } else {
            dice[5] = map[X][Y];
            map[X][Y] = 0;
        }
    }

    private static boolean imMoveable(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
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
