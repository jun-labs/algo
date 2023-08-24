package programmers.여행경로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    private boolean[] visited;
    private List<String> allRoute;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int count = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, count);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");
        return answer;
    }

    public void dfs(String start, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            allRoute.add(route);
            return;
        }

        for (int index = 0; index < tickets.length; index++) {
            if (start.equals(tickets[index][0]) && !visited[index]) {
                visited[index] = true;
                dfs(tickets[index][1], route + " " + tickets[index][1], tickets, count + 1);
                visited[index] = false;
            }
        }
    }
}
