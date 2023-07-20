package programmers.디펜스_게임;

import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Collections.reverseOrder;

public class Solution {

    public int solution(int n, int k, int[] enemy) {
        int length = enemy.length;

        Queue<Integer> queue = new PriorityQueue<>(reverseOrder());

        for (int index = 0; index < length; index++) {
            int count = enemy[index];
            n -= count;
            queue.add(count);
            if (n < 0) {
                if (k >= 1 && !queue.isEmpty()) {
                    k -= 1;
                    n += queue.poll();
                } else {
                    return index;
                }
            }
        }
        return length;
    }
}
