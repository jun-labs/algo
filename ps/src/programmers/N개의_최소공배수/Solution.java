package programmers.N개의_최소공배수;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        int[] arr = {2, 6, 8, 14};
        Solution solution = new Solution();
        System.out.println(solution.solution(arr));
    }

    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        Arrays.sort(arr);
        int answer = arr[0];
        for (int index = 1; index < arr.length; index++) {
            answer = (answer * arr[index]) / getGCD(answer, arr[index]);
        }
        return answer;
    }

    public int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}
