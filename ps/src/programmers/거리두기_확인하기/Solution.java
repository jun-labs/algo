package programmers.거리두기_확인하기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int[] solution(String[][] seats) {
        int[] answer = new int[seats.length];
        for (int index = 0; index < seats.length; index++) {
            answer[index] = isSafe(seats[index]);
        }
        return answer;
    }

    private int isSafe(String[] seat) {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (seat[x].charAt(y) == 'P') {
                    if (!findSeat(x, y, seat)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private boolean findSeat(int x, int y, String[] seat) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nextX = poll.x + dx[direction];
                int nextY = poll.y + dy[direction];
                if (!moveable(nextX, nextY)) {
                    continue;
                }
                int manhattan = Math.abs(nextX - x) + Math.abs(nextY - y);
                if (visited[nextX][nextY] || manhattan > 2) {
                    continue;
                }
                visited[nextX][nextY] = true;
                if (seat[nextX].charAt(nextY) == 'O') {
                    queue.add(new Point(nextX, nextY));
                } else if (seat[nextX].charAt(nextY) == 'P') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean moveable(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
