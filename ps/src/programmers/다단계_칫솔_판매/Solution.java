package programmers.다단계_칫솔_판매;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private final Map<String, Node> nodes = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        Solution solution = new Solution();
        System.out.println(solution.solution(enroll, referral, seller, amount));
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (String eachEnroll : enroll) {
            nodes.putIfAbsent(eachEnroll, new Node(eachEnroll));
        }

        for (int index = 0; index < enroll.length; index++) {
            String eachReferral = referral[index];
            if (!eachReferral.equals("-")) {
                nodes.get(enroll[index]).parent = nodes.get(eachReferral);
            }
        }

        for (int index = 0; index < seller.length; index++) {
            dfs(nodes.get(seller[index]), amount[index] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int index = 0; index < enroll.length; index++) {
            answer[index] = nodes.get(enroll[index]).money;
        }

        return answer;
    }

    void dfs(Node node, int money) {
        if (money < 1) {
            return;
        }

        int ownProfit = (int) (money * 0.9);
        int referralProfit = money - ownProfit;

        node.money += ownProfit;

        if (node.parent != null && referralProfit > 0) {
            dfs(node.parent, referralProfit);
        }
    }

    static class Node {

        Node parent;
        String name;
        int money = 0;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.valueOf(money);
        }
    }
}
