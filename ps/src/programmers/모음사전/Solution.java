package programmers.모음사전;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static char[] letters = {'A', 'E', 'I', 'O', 'U'};
    static List<String> answers;

    public int solution(String word) {
        int answer = 0;
        answers = new ArrayList<>();
        int index = 1;

        for (int length = 1; length <= 5; length++) {
            dfs(0, "", length);
        }

        Collections.sort(answers);

        for (String alpha : answers) {
            if (alpha.equals(word)) {
                return answer;
            }
            index++;
        }
        return index;
    }

    private void dfs(int depth, String word, int length) {
        if (depth == length) {
            answers.add(word);
            return;
        }
        for (char letter : letters) {
            dfs(depth + 1, word + letter, length);
        }
    }
}
