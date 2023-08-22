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

        for (int[] node : edge) {
            int from = node[0];
            int to = node[1];
            nodes[from].add(to);
            nodes[to].add(from);
        }

        visited[0] = true;
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> linkedNodes = nodes[node];

            for (Integer linkedNode : linkedNodes) {
                if (visited[linkedNode]) {
                    continue;
                }
                queue.add(linkedNode);
                visited[linkedNode] = true;
                distances[linkedNode] = distances[node] + 1;
            }
        }

        Arrays.sort(distances);

        int max = distances[n];
        int count = 0;
        for (int index = n; index >= 1; index--) {
            if (max == distances[index]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
