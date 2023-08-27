package programmers.타겟_넘버;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static int end;

    public int solution(int[] numbers, int target) {
        end = numbers.length;

        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(0, 0));

        int answer = 0;
        while (!queue.isEmpty()) {
            Number number = queue.poll();

            if (number.value > end) {
                continue;
            }

            if (number.isEnd()) {
                if (number.isTarget(target)) {
                    answer++;
                }
            } else {
                queue.add(new Number(number.value + numbers[number.order], number.order + 1));
                queue.add(new Number(number.value - numbers[number.order], number.order + 1));
            }
        }
        return answer;
    }

    static class Number {

        int value;
        int order;

        public Number(int value, int order) {
            this.value = value;
            this.order = order;
        }

        boolean isEnd() {
            return end == order;
        }

        boolean isTarget(int target) {
            return this.value == target;
        }
    }
}
