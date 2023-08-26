package programmers.네트워크;

public class Solution {

    private int[][] connection;
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        connection = computers;
        visited = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(node);
                answer += 1;
            }
        }
        return answer;
    }

    private void dfs(int node) {
        for (int row = 0; row < connection.length; row++) {
            for (int col = 0; col < connection[0].length; col++) {
                if (!visited[col] && connection[node][col] > 0) {
                    visited[col] = true;
                    dfs(col);
                }
            }
        }
    }
}
