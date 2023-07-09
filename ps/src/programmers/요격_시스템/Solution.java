package programmers.요격_시스템;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private int answer = 0;
    private int targetLine = -100_000_000;

    public int solution(int[][] targets) {
        List<Line> lines = new ArrayList<>();

        for (int[] temp : targets) {
            int start = temp[0];
            int end = temp[1];
            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        for (Line line : lines) {
            if (line.start >= targetLine) {
                answer++;
                targetLine = line.end;
            }
        }
        return answer;
    }

    static class Line implements Comparable<Line> {

        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] lines = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        Solution solution = new Solution();
        System.out.println(solution.solution(lines));
    }
}
