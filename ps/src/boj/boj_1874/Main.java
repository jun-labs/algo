package boj.boj_1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Input input = new Input();

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = input.getInteger();
        int[] numbers = new int[n + 1];
        int idx = 1;
        for (int index = 1; index <= n; index++) {
            numbers[index] = input.getInteger();
        }

        for (int index = 1; index <= n; index++) {
            stack.push(index);
            sb.append("+")
                .append("\n");
            while (!stack.isEmpty() && stack.peek() == numbers[idx]) {
                stack.pop();
                sb.append("-")
                    .append("\n");
                idx++;
            }
        }
        if (stack.isEmpty()) {
            System.out.println(sb);
            System.exit(0);
        }
        System.out.println("NO");
    }

    static class Input {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
    }
}
