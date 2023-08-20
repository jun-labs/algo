package programmers.H_Index;

import java.util.Arrays;

public class Solution {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int length = citations.length;
        int answer = 0;
        for (int index = 0; index < length; index++) {
            if (citations[index] >= length - index) {
                answer = length - index;
                break;
            }
        }
        return answer;
    }
}
