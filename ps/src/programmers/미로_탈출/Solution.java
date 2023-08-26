package programmers.미로_탈출;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    private String[][] maze;
    private boolean[][] visited;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {
        maze = new String[maps.length][maps[0].length()];
        Point source = null;
        Point target = null;
        Point lever = null;

        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[0].length(); col++) {
                maze[row][col] = maps[row].split("")[col];
                if (maze[row][col].equals("S")) {
                    source = new Point(row, col, 0);
                }
                if (maze[row][col].equals("L")) {
                    lever = new Point(row, col, 0);
                }
                if (maze[row][col].equals("E")) {
                    target = new Point(row, col, 0);
                }
            }
        }

        int distanceToLever = move(source, lever);
        if (distanceToLever == -1) {
            return distanceToLever;
        }

        lever.count = distanceToLever;
        int distanceToTarget = move(lever, target);
        if (distanceToTarget == -1) {
            return distanceToTarget;
        }
        return distanceToTarget;
    }

    private int move(Point source, Point target) {
        visited = initVisited();
        visited[source.x][source.y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.equals(target)) {
                return point.count;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextX = point.x + dx[direction];
                int nextY = point.y + dy[direction];

                if (!moveable(nextX, nextY)) {
                    continue;
                }
                visited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY, point.count + 1));
            }
        }
        return -1;
    }

    private boolean moveable(int x, int y) {
        return (x >= 0 && x < maze.length) &&
            (y >= 0 && y < maze[0].length) &&
            (!(maze[x][y].equals("X"))) &&
            (!visited[x][y]);
    }

    private boolean[][] initVisited() {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                if (maze[row][col].equals("X")) {
                    visited[row][col] = true;
                }
            }
        }
        return visited;
    }

    static class Point {

        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Point)) {
                return false;
            }
            Point point = (Point) object;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
