package programmers.양과_늑대;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private int answer = 0;
    private int[] info;
    private List[] nodes = new ArrayList[17];

    public int solution(int[] _info, int[][] edges) {
        info = _info;
        for (int index = 0; index < 17; index++) {
            nodes[index] = new ArrayList();
        }

        for (int index = 0; index < edges.length; index++) {
            int[] edge = edges[index];
            nodes[edge[0]].add(edge[1]);
        }

        dfs(1, 0, 0, new HashSet<>());
        return answer;
    }

    private void dfs(int sheep, int wolf, int index, Set<Integer> next) {
        answer = Math.max(answer, sheep);

        Set<Integer> nodes = new HashSet<>();
        nodes.addAll(next);
        nodes.addAll(this.nodes[index]);
        nodes.remove(Integer.valueOf(index));

        for (int node : nodes) {
            int nextSheep = sheep + (info[node] == 0 ? 1 : 0);
            int nextWolf = wolf + (info[node] == 1 ? 1 : 0);

            if (nextSheep > nextWolf) {
                dfs(nextSheep, nextWolf, node, nodes);
            }
        }
    }
}
