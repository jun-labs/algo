package programmers._2xn타일링;

public class Solution {
    static int[] array;
    static long DIVISION = 1000000007;

    public int solution(int n) {
        array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;

        for (int index = 2; index <= n; index++) {
            array[index] = array[index - 1] + array[index - 2];
            array[index] %= DIVISION;
        }
        return array[n];
    }
}
