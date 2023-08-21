package programmers.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private String[][] map;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        String[] map = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        Solution solution = new Solution();
        System.out.println(solution.solution(map));
    }

    public int solution(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        Point source = new Point(-1, -1);
        Point lever = new Point(-1, -1);
        Point target = new Point(-1, -1);

        for (int x = 0; x < maps.length; x++) {
            for (int y = 0; y < maps[0].length(); y++) {
                map[x][y] = maps[x].split("")[y];
                if (map[x][y].equals("S")) {
                    source.x = x;
                    source.y = y;
                }
                if (map[x][y].equals("L")) {
                    lever.x = x;
                    lever.y = y;
                }
                if (map[x][y].equals("E")) {
                    target.x = x;
                    target.y = y;
                }
            }
        }

        int distanceToLever = getDistance(source, lever);
        if (distanceToLever == -1) {
            return -1;
        }

        int distanceToTarget = getDistance(
            new Point(lever.x, lever.y, distanceToLever),
            target
        );
        if (distanceToTarget == -1) {
            return -1;
        }
        return distanceToTarget;
    }

    private int getDistance(Point source, Point target) {
        boolean[][] visited = init();
        visited[source.x][source.y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int count = point.count;

            if (x == target.x && y == target.y) {
                return count;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextX = x + dx[direction];
                int nextY = y + dy[direction];
                if (moveable(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY, count + 1));
                }
            }
        }
        return -1;
    }

    private boolean moveable(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && !map[x][y].equals("X");
    }

    private boolean[][] init() {
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y].equals("X")) {
                    visited[x][y] = true;
                }
            }
        }
        return visited;
    }

    static class Point {

        int x;
        int y;
        int count;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
