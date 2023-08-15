package programmers.점프와_순간_이동;

public class Solution {

    public int solution(int n) {
        if (n == 1) {
            return 1;
        }

        int energy = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                energy++;
            }
        }
        return energy;
    }
}
