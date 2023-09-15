package programmers.다음_큰_숫자;

public class Solution {

    public int solution(int n) {
        int count = Integer.bitCount(n);
        while (true) {
            n++;
            int nextCount = Integer.bitCount(n);
            if (nextCount == count) {
                return n;
            }
        }
    }
}
