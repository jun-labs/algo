package programmers.최댓값과_최솟값;

public class Solution {

    int min = 100_000;
    int max = -100_000;

    public String solution(String s) {
        String[] array = s.split(" ");
        for (String str : array) {
            min = Math.min(Integer.parseInt(str), min);
            max = Math.max(Integer.parseInt(str), max);
        }
        return min + " " + max;
    }
}
