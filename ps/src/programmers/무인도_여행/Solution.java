package programmers.무인도_여행;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private String[][] strMap;
    private boolean[][] visited;
    private int dx[] = {1, -1, 0, 0};
    private int dy[] = {0, 0, 1, -1};

    public int[] solution(String[] maps) {
        strMap = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int x = 0; x < maps.length; x++) {
            String[] temp = maps[x].split("");
            for (int y = 0; y < maps[0].length(); y++) {
                strMap[x][y] = temp[y];
                if (strMap[x][y].equals("X")) {
                    visited[x][y] = true;
                }
            }
        }

        List<Integer> numbers = new ArrayList<>();
        for (int x = 0; x < maps.length; x++) {
            for (int y = 0; y < maps[0].length(); y++) {
                if (!visited[x][y]) {
                    numbers.add(getNumber(x, y));
                }
            }
        }

        Collections.sort(numbers);
        int[] ans = new int[numbers.size()];
        for (int index = 0; index < numbers.size(); index++) {
            ans[index] = numbers.get(index);
        }
        return numbers.isEmpty() ? new int[]{-1} : ans;
    }

    private int getNumber(int x, int y) {
        int answer = 0;
        answer += Integer.parseInt(strMap[x][y]);
        visited[x][y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int pointX = poll.x;
            int pointY = poll.y;

            for (int direction = 0; direction < 4; direction++) {
                int nextX = pointX + dx[direction];
                int nextY = pointY + dy[direction];
                if (moveable(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                    answer += Integer.parseInt(strMap[nextX][nextY]);
                }
            }
        }
        return answer;
    }

    private boolean moveable(int x, int y) {
        return x >= 0 && x < strMap.length && y >= 0 && y < strMap[0].length;
    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
