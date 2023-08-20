package programmers.가장_큰_수;

import java.util.Arrays;

public class Solution {

    public String solution(int[] numbers) {
        String[] array = new String[numbers.length];
        for (int index = 0; index < numbers.length; index++) {
            array[index] = String.valueOf(numbers[index]);
        }

        Arrays.sort(array, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder sb = new StringBuilder();
        for (String number : array) {
            sb.append(number);
        }

        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
