package programmers.전화번호_목록;

import java.util.Arrays;

class Solution {

    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int index = 0; index < phoneBook.length - 1; index++) {
            if (phoneBook[index + 1].indexOf(phoneBook[index]) == 0) {
                return false;
            }
        }
        return true;
    }
}
