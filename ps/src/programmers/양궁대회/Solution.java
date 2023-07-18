package programmers.양궁대회;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int max = Integer.MIN_VALUE;
    private int count;
    private List<int[]> lst = new ArrayList<>();
    private int[] ryan;
    private int[] apeach;

    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        count = n;
        apeach = info;
        dfs(0, 0);

        if (max == Integer.MIN_VALUE) return new int[]{-1};

        lst.sort((o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        return lst.get(0);
    }

    private void dfs(int depth, int start) {
        if (count == depth) {
            int ryanSum = 0;
            int apeachSum = 0;

            for (int index = 0; index < ryan.length; index++) {
                if (ryan[index] == 0 && apeach[index] == 0) continue;
                else if (apeach[index] >= ryan[index]) apeachSum += (10 - index);
                else ryanSum += (10 - index);
            }
            if (ryanSum > apeachSum) {
                int diff = ryanSum - apeachSum;
                if (diff > max) {
                    max = diff;
                    lst.clear();
                    lst.add(ryan.clone());
                } else if (diff == max) {
                    lst.add(ryan.clone());
                }
            }
            return;
        }

        for (int index = start; index < ryan.length; index++) {
            ryan[index]++;
            dfs(depth + 1, index);
            ryan[index]--;
        }
    }
}
