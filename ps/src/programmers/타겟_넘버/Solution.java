package programmers.타겟_넘버;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[] numbers, int target) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(0, 0));

        int answer = 0;
        while (!queue.isEmpty()) {
            Number number = queue.poll();
            if (number.order == numbers.length) {
                if (number.value == target) {
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
    }
}
