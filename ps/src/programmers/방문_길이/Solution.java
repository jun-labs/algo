package programmers.방문_길이;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Solution {

    private static Set<Point> histories = new HashSet<>();
    private static Map<String, Integer> directions = new HashMap<>();
    private static int[] dx = {1, -1, 0, 0};    // 남 북 동 서
    private static int[] dy = {0, 0, 1, -1};

    static {
        directions.put("R", 2);
        directions.put("L", 3);
        directions.put("D", 0);
        directions.put("U", 1);
    }

    public int solution(String dirs) {
        Queue<String> commands = new LinkedList<>();
        String[] temp = dirs.split("");
        for (String command : temp) {
            commands.add(command);
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(5, 5, 5, 5, 0));
        int answer = 0;
        while (!commands.isEmpty()) {
            Point point = queue.poll();
            int x = point.nextX;
            int y = point.nextY;

            String command = commands.poll();
            int direction = directions.get(command);

            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            if (!moveable(nextX, nextY)) {
                queue.add(point);
                continue;
            }
            Point pointHistory = new Point(nextX, nextY, x, y);
            if (!has(pointHistory)) {
                Point nextPoint = new Point(nextX, nextY, x, y, point.count + 1);
                Point reversePoint = new Point(x, y, nextX, nextY, point.count + 1);
                histories.add(nextPoint);
                histories.add(reversePoint);
                queue.add(nextPoint);
                answer = point.count + 1;
                continue;
            }
            if (has(pointHistory)) {
                Point nextPoint = new Point(nextX, nextY, x, y, point.count);
                queue.add(nextPoint);
            }
        }
        return answer;
    }

    private boolean moveable(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }

    private boolean has(Point point) {
        return histories.contains(point);
    }

    static class Point {

        int nextX;
        int nextY;
        int beforeX;
        int beforeY;
        int count;

        public Point(int nextX, int nextY, int beforeX, int beforeY) {
            this.nextX = nextX;
            this.nextY = nextY;
            this.beforeX = beforeX;
            this.beforeY = beforeY;
        }

        public Point(int nextX, int nextY, int beforeX, int beforeY, int count) {
            this.nextX = nextX;
            this.nextY = nextY;
            this.beforeX = beforeX;
            this.beforeY = beforeY;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point point = (Point) o;
            return nextX == point.nextX && nextY == point.nextY && beforeX == point.beforeX
                && beforeY == point.beforeY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nextX, nextY, beforeX, beforeY);
        }
    }
}
