package boj.boj_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List[] temp;
    static Input input = new Input();
    static boolean[] virus;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        n = input.getInteger();
        m = input.getInteger();
        temp = new ArrayList[n + 1];

        for (int index = 1; index <= n; index++) {
            temp[index] = new ArrayList();
        }
        virus = new boolean[n + 1];
        visited = new boolean[n + 1];

        for (int index = 1; index <= m; index++) {
            int from = input.getInteger();
            int to = input.getInteger();
            temp[from].add(to);
            temp[to].add(from);
        }

        visited[0] = true;
        visited[1] = true;
        virus[1] = true;
        dfs(1);

        int answer = 0;
        for (int index = 2; index <= n; index++) {
            if (virus[index]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int index) {
        List<Integer> linkedList = temp[index];

        for (Integer node : linkedList) {
            if (!visited[node]) {
                virus[node] = true;
                visited[index] = true;
                dfs(node);
            }
        }
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
