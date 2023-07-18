package etc.문자열_펠린드롬;

public class Solution {
    private final StringBuilder sb = new StringBuilder();
    private static char[] characters = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public void pelindrome(int l, int n) {
        validate(l, n);
        int length = (l % 2 == 0 ? l / 2 : l / 2 + 1);

        int alphaCount = 0;
        while (length > 0) {
            length--;
            if (alphaCount >= n) {
                sb.append(characters[0]);
            } else {
                sb.append(characters[alphaCount]);
                alphaCount++;
            }
        }

        String temp = sb.toString();
        int end = l % 2 == 0 ? temp.length() - 1 : temp.length() - 2;
        for (int index = end; index >= 0; index--) {
            sb.append(temp.charAt(index));
        }
        System.out.println(sb);
    }

    private void validate(int l, int n) {
        if (l % 2 == 0) {
            if (n > (l / 2)) {
                throw new IllegalArgumentException("만들 수 없는 조합입니다.");
            }
        } else {
            if (n > (l / 2 + 1)) {
                throw new IllegalArgumentException("만들 수 없는 조합입니다.");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.pelindrome(100_000_000, 6);
    }
}
