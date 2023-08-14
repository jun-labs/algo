package programmers.괄호_변환;

public class Solution {

    private static final char START_BRACKET = '(';
    private static final char END_BRACKET = ')';
    private static final String EMPTY_STRING = "";

    public String solution(String p) {
        return dfs(p);
    }

    private String dfs(String p) {
        if (p.length() == 0) {
            return p;
        }
        String u = EMPTY_STRING;
        String v = EMPTY_STRING;

        StringBuilder splitSb = new StringBuilder();
        for (int index = 0; index < p.length(); index++) {
            splitSb.append(p.charAt(index));
            if (isBalancedBracket(splitSb.toString())) {
                u = splitSb.toString();
                v = p.substring(index + 1);
                break;
            }
        }

        if (isCorrectBracket(u)) {
            return u + dfs(v);
        } else {
            StringBuilder plusSb = new StringBuilder();
            plusSb.append(START_BRACKET);
            plusSb.append(dfs(v));
            plusSb.append(END_BRACKET);
            u = u.substring(1, u.length() - 1);

            for (int index = 0; index < u.length(); index++) {
                if (u.charAt(index) == START_BRACKET) {
                    plusSb.append(END_BRACKET);
                } else {
                    plusSb.append(START_BRACKET);
                }
            }
            return plusSb.toString();
        }
    }

    public boolean isBalancedBracket(String p) {
        int startBracketCount = 0;
        int endBracketCount = 0;

        for (int index = 0; index < p.length(); index++) {
            if (p.charAt(index) == START_BRACKET) {
                startBracketCount++;
            } else {
                endBracketCount++;
            }
        }
        return startBracketCount == endBracketCount;
    }

    private boolean isCorrectBracket(String word) {
        int length = word.length();
        if (length % 2 != 0) {
            return false;
        }

        int startBracketCount = 0;
        int endBracketCount = 0;
        for (int index = 0; index < length; index++) {
            if (word.charAt(index) == START_BRACKET) {
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
