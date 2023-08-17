package programmers.큰_수_만들기;

public class Solution {

    public String solution(String number, int k) {
        int start = 0;
        int length = number.length() - k;
        StringBuilder sb = new StringBuilder();

        while (start < number.length() && sb.length() != length) {
            int leftNumber = k + sb.length();
            int max = 0;
            for (int index = start; index <= leftNumber; index++) {
                if (max < number.charAt(index) - '0') {
                    max = number.charAt(index) - '0';
                    start = index + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
