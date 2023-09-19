package boj.boj_2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static Input input = new Input();
    private static int[] indegree;
    private static List<Integer>[] relationship;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        int m = input.getInteger();

        relationship = new ArrayList[n + 1];
        indegree = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            relationship[index] = new ArrayList<>();
        }

        for (int index = 0; index < m; index++) {
            int studentA = input.getInteger();
            int studentB = input.getInteger();
            indegree[studentB] += 1;
            relationship[studentA].add(studentB);
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int index = 1; index <= n; index++) {
            if (indegree[index] == 0) {
                queue.add(index);
            }
        }
        while (!queue.isEmpty()) {
            int student = queue.poll();
            System.out.print(student + " ");
            List<Integer> people = relationship[student];

            for (Integer person : people) {
                indegree[person] -= 1;
                if (indegree[person] == 0) {
                    queue.add(person);
                }
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

        public String next() throws Exception {
            if (!st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
    }
}
