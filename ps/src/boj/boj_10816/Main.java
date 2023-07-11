package boj.boj_10816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final String DELIMETER = " ";
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int[] cards;
    private static int[] targets;

    public static void main(String[] args) throws Exception {
        int n = input.getInteger();
        cards = new int[n];
        for (int index = 0; index < n; index++) {
            cards[index] = input.getInteger();
            int value = map.getOrDefault(cards[index], 0) + 1;
            map.put(cards[index], value);
        }

        int m = input.getInteger();
        targets = new int[m];
        for (int index = 0; index < m; index++) {
            targets[index] = input.getInteger();
        }

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            boolean exist = binarySearch(target);

            if (exist) {
                sb.append(map.get(target))
                        .append(DELIMETER);
            } else {
                sb.append(0)
                        .append(DELIMETER);
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int target) {
        int start = 0;
        int end = cards.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (cards[mid] == target) {
                return true;
            } else if (cards[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
