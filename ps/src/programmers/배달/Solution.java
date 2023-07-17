package programmers.배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private List<Node>[] nodes;
    private int[] costs;

    public int solution(int N, int[][] roads, int K) {
        nodes = new ArrayList[N + 1];
        costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int index = 1; index <= N; index++) {
            nodes[index] = new ArrayList<>();
        }

        for (int[] road : roads) {
            nodes[road[0]].add(new Node(road[1], road[2]));
            nodes[road[1]].add(new Node(road[0], road[2]));
        }
        costs[1] = 0;
        dijkstra();

        int answer = 0;
        for (int cost : costs) {
            if (cost <= K) {
                answer++;
            }
        }
        return answer;
    }

    private void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currentCity = node.city;
            int currentWeight = node.weight;

            if (costs[currentCity] < currentWeight) {
                continue;
            }

            List<Node> linkedNodes = nodes[currentCity];
            for (Node nextNode : linkedNodes) {
                int nextCity = nextNode.city;
                int nextWeight = nextNode.weight + currentWeight;
                if (costs[nextCity] > nextWeight) {
                    costs[nextCity] = nextWeight;
                    queue.add(new Node(nextCity, nextWeight));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int city;
        int weight;

        public Node(int city, int weight) {
            this.city = city;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int N = 5;
        int K = 3;
        Solution solution = new Solution();
        System.out.println(solution.solution(N, road, K));
    }
}
