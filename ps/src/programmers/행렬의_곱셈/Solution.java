package programmers.행렬의_곱셈;

public class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int x = 0; x < arr1.length; x++) {
            for (int y = 0; y < arr2[0].length; y++) {
                for (int k = 0; k < arr2.length; k++) {
                    answer[x][y] += (arr1[x][k] * arr2[k][y]);
                }
            }
        }
        return answer;
    }
}
