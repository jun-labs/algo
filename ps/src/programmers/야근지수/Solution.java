package programmers.야근지수;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    private long answer = 0;

    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer work : works) {
            queue.add(work);
        }

        while (n > 0) {
            Integer work = queue.poll();
            if (work == 0) {
                break;
            }
            work -= 1;
            queue.add(work);
            n -= 1;
        }

        for (Integer work : queue) {
            answer += Math.pow(work, 2);
        }
        return answer;
    }
}
