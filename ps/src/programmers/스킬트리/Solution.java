package programmers.스킬트리;

public class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String eachSkill : skill_trees) {
            String temp = eachSkill;
            for (int index = 0; index < eachSkill.length(); index++) {
                String prefix = String.valueOf(eachSkill.charAt(index));
                if (!skill.contains(prefix)) {
                    temp = temp.replace(prefix, "");
                }
            }
            if (skill.indexOf(temp) == 0) {
                answer++;
            }
        }
        return answer;
    }
}
