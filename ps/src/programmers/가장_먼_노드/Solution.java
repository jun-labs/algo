package programmers.가장_먼_노드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private int[] distances;
    private List[] nodes;
    private boolean[] visited;

    public int solution(int n, int[][] edge) {
        distances = new int[n + 1];
        visited = new boolean[n + 1];

        nodes = new List[n + 1];
        for (int index = 1; index <= n; index++) {
            nodes[index] = new ArrayList();
        }

        for (int[] eachEdge : edge) {
            int from = eachEdge[0];
            int to = eachEdge[1];
            nodes[from].add(to);
            nodes[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            List<Integer> linkedNodes = nodes[currentNode];
            for (Integer linkedNode : linkedNodes) {
                if (!visited[linkedNode]) {
                    visited[linkedNode] = true;
                    queue.add(linkedNode);
                    distances[linkedNode] = distances[currentNode] + 1;
                }
            }
        }
        Arrays.sort(distances);
        int max = distances[n];
        int answer = 0;
        for (int index = 1; index <= n; index++) {
            if (distances[index] == max) {
                answer++;
            }
        }
        return answer;
    }
}
