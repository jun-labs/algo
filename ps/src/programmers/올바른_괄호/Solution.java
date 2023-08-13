package programmers.올바른_괄호;

public class Solution {

    private char startBracket = '(';

    public boolean solution(String s) {
        int startBracketCount = 0;
        int endBracketCount = 0;

        if (s.length() == 0) {
            return false;
        }

        for (int index = 0; index < s.length(); index++) {
            char bracket = s.charAt(index);
            if (bracket == startBracket) {
                startBracketCount++;
            } else {
                endBracketCount++;
            }

            if (endBracketCount > startBracketCount) {
                return false;
            }
        }
        return startBracketCount == endBracketCount;
    }
}
