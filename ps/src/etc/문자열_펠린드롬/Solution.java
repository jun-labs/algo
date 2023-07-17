package etc.문자열_펠린드롬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private static char[] characters;

    public Set<String> solve(int l, int n) throws Exception {
        characters = new char[n];
        for (int index = 0; index < n; index++) {
            characters[index] = input.getString().charAt(0);
        }

        Set<String> set = new HashSet<>();
        int length = (l % 2 == 0 ? l / 2 : l / 2 + 1);
        for (int index = 0; index < characters.length; index++) {
            dfs(length, "", set);
        }
        return set;
    }

    void dfs(int length, String character, Set<String> set) {
        if (character.length() == length && character.length() % 2 != 0) {
            StringBuilder characterBuilder = new StringBuilder(character);
            for (int index = length - 2; index >= 0; index--) {
                characterBuilder.append(characterBuilder.charAt(index));
            }
            set.add(characterBuilder.toString());
            return;
        }
        if (character.length() == length) {
            StringBuilder characterBuilder = new StringBuilder(character);
            for (int index = length - 1; index >= 0; index--) {
                characterBuilder.append(characterBuilder.charAt(index));
            }
            set.add(characterBuilder.toString());
            return;
        }

        for (int index = 0; index < characters.length; index++) {
            dfs(length, character + characters[index], set);
        }
    }

    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int getInteger() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String getString() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.solve(5, 2));
    }
}
