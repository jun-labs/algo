package programmers.이진_변환_반복하기;

public class Solution {

    public int[] solution(String s) {
        int changeCount = 0;
        int count = 0;

        while (!s.equals("1")) {
            changeCount += 1;
            String afterRemoveZero = s.replaceAll("0", "");
            count += (s.length() - afterRemoveZero.length());
            s = Integer.toBinaryString(afterRemoveZero.length());
        }
        return new int[]{changeCount, count};
    }
}
