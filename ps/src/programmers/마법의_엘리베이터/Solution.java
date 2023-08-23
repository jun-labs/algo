package programmers.마법의_엘리베이터;

// 참조: https://velog.io/@goldilocks/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A7%88%EB%B2%95%EC%9D%98-%EC%97%98%EB%A6%AC%EB%B2%A0%EC%9D%B4%ED%84%B0Java
public class Solution {

    public static void main(String[] args) throws Exception {
        int storey = 2554;
        Solution solution = new Solution();
        System.out.println(solution.solution(storey));
    }

    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int firstDigit = storey % 10;
            int secondDigit = (storey / 10) % 10;

            if (firstDigit > 5) {
                answer += (10 - firstDigit);
                storey += 10;
            } else if (firstDigit == 5) {
                answer += 5;
                if (secondDigit >= 5) {
                    storey += 10;
                }
            } else {
                answer += firstDigit;
            }

            storey /= 10;
        }
        return answer;
    }
}
