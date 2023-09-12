package programmers.올바른_괄호;

import java.util.Stack;

public class Solution {

    private char startBracket = '(';

    public boolean solution(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            char bracket = s.charAt(index);

            if (bracket == startBracket) {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else {
                    stack.push(bracket);
                }
            }
        }
        return stack.isEmpty();
    }
}
