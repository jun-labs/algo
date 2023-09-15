package programmers.이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private final PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for (int index = 0; index < operations.length; index++) {
            String element = operations[index];
            String[] temp = element.split(" ");
            String command = temp[0];
            Integer value = Integer.parseInt(temp[1]);

            if (queue.isEmpty() && command.equals("D")) {
                continue;
            }
            if (command.equals("I")) {
                queue.add(value);
                maxQueue.add(value);
                continue;
            }
            if (value < 0) {
                int min = queue.poll();
                maxQueue.remove(min);
                continue;
            }
            int max = maxQueue.poll();
            queue.remove(max);
        }
        if (!queue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = queue.poll();
        }
        return answer;
    }
}
