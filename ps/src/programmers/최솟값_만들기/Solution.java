package programmers.최솟값_만들기;

import java.util.Arrays;

class Solution {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for (int index = 0; index < A.length; index++) {
            answer += (A[index] * B[A.length - 1 - index]);
        }
        return answer;
    }
}
