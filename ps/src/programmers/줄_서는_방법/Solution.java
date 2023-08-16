package programmers.줄_서는_방법;

import java.util.*;

public class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();

        for (int index = 1; index <= n; index++) {
            numbers.add(index);
        }

        k = k - 1;
        for (int index = 0; index < n; index++) {
            long factorial = factorial(n - 1 - index);
            int targetIndex = (int) (k / factorial);
            answer[index] = numbers.get(targetIndex);
            numbers.remove(targetIndex);
            k = k % factorial;
        }
        return answer;
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
