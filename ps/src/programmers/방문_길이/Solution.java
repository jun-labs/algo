package programmers.방문_길이;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Map<String, Integer> direction = new HashMap<>();
    private static List<History> historyList = new ArrayList<>();

    static {
        direction.put("R", 2);
        direction.put("L", 3);
        direction.put("D", 0);
        direction.put("U", 1);
    }

    public static int solution(String dirs) {
        int answer = 0;
        Queue<String> commands = new LinkedList<>();

        for (int index = 0; index < dirs.length(); index++) {
            commands.add(String.valueOf(dirs.charAt(index)));
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(5, 5, 5, 5, 0));

        while (!commands.isEmpty()) {
            String command = commands.poll();
            Point point = queue.poll();
            int x = point.nextX;
            int y = point.nextY;

            int nextX = x + dx[direction.get(command)];
            int nextY = y + dy[direction.get(command)];
            History history = new History(nextX, nextY, x, y);

            if (moveable(nextX, nextY) && !hasHistory(history)) {
                queue.add(new Point(nextX, nextY, x, y, point.count + 1));
                historyList.add(history);
                historyList.add(new History(x, y, nextX, nextY));
                answer = point.count + 1;
                continue;
            }
            if (moveable(nextX, nextY) && hasHistory(history)) {
                queue.add(new Point(nextX, nextY, x, y, point.count));
                continue;
            }
            if (!moveable(nextX, nextY)) {
                queue.add(point);
            }
        }
        return answer;
    }

    static boolean moveable(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }

    static boolean hasHistory(History history) {
        return historyList.contains(history);
    }

    static class Point {

        int nextX;
        int nextY;
        int beforeX;
        int beforeY;
        int count;

        public Point(int nextX, int nextY, int beforeX, int beforeY, int count) {
            this.nextX = nextX;
            this.nextY = nextY;
            this.beforeX = beforeX;
            this.beforeY = beforeY;
            this.count = count;
        }
    }

    static class History {

        int nextX;
        int nextY;
        int beforeX;
        int beforeY;

        public History(int nextX, int nextY, int beforeX, int beforeY) {
            this.nextX = nextX;
            this.nextY = nextY;
            this.beforeX = beforeX;
            this.beforeY = beforeY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof History)) {
                return false;
            }
            History history = (History) o;
            return nextX == history.nextX && nextY == history.nextY && beforeX == history.beforeX
                && beforeY == history.beforeY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nextX, nextY, beforeX, beforeY);
        }
    }
}
