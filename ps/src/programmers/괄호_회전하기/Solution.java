package programmers.괄호_회전하기;

import java.util.Stack;

class Solution {

    public int solution(String s) {
        int answer = 0;
        for (int index = 0; index < s.length(); index++) {
            String movedStr = s.substring(1) + s.charAt(0);
            if (isValidBracket(movedStr)) {
                answer += 1;
            }
            s = movedStr;
        }
        return answer;
    }

    public boolean isValidBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < str.length(); index++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(index));
            } else {
                if (str.charAt(index) == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(index));
                    }
                } else if (str.charAt(index) == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(index));
                    }
                } else if (str.charAt(index) == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(index));
                    }
                } else {
                    stack.push(str.charAt(index));
                }
            }
        }
        return stack.isEmpty();
    }
}
