package programmers.부대복귀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private static final int MAX = Integer.MAX_VALUE;
    private static List<List<Integer>> graph;
    private static int[] dis;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dis = new int[n + 1];
        Arrays.fill(dis, MAX);
        dijkstra(destination);

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (dis[sources[i]] < MAX) ? dis[sources[i]] : -1;
        }
        return answer;
    }

    private void dijkstra(int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        dis[destination] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int index = 0; index < graph.get(currentNode).size(); index++) {
                int nextNode = graph.get(currentNode).get(index);
                if (dis[nextNode] > dis[currentNode] + 1) {
                    dis[nextNode] = dis[currentNode] + 1;
                    queue.add(nextNode);
                }
            }
        }
    }
}

