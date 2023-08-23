package programmers.두_큐_합_같게_만들기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    private static int answer = 100_000;
    private Queue<Integer> queueA;
    private Queue<Integer> queueB;

    public int solution(int[] queue1, int[] queue2) {
        queueA = Arrays.stream(queue1).boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        queueB = Arrays.stream(queue2).boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        long queueASum = sum(queue1);
        long queueBSum = sum(queue2);

        long sum = queueASum + queueBSum;

        if (sum % 2 != 0) {
            return -1;
        }

        long target = sum / 2;
        int maxCount = queueA.size() + queueB.size();
        int aCount = 0;
        int bCount = 0;

        while (aCount <= maxCount && bCount <= maxCount) {
            if (queueASum == target) {
                return aCount + bCount;
            }
            if (queueASum < target) {
                Integer value = queueB.poll();
                queueASum += value;
                queueBSum -= value;
                queueA.add(value);
                aCount++;
            } else {
                Integer value = queueA.poll();
                queueASum -= value;
                queueBSum += value;
                queueB.add(value);
                bCount++;
            }
        }
        return -1;
    }

    private long sum(int[] queue) {
        long sum = 0;

        for (int value : queue) {
            sum += value;
        }
        return sum;
    }
}
