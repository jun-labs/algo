package programmers.영어_끝말잇기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private final List<String> duplicatedWords = new ArrayList<>();
    private String lastWord;

    public static void main(String[] args) throws Exception {
        String[] words = {
            "tank", "kick", "know", "wheel", "land",
            "dream", "mother", "robot", "tank"
        };
        String[] words2 = {
            "hello", "observe", "effect", "take", "either",
            "recognize", "encourage", "ensure", "establish", "hang",
            "gather", "refer", "reference", "estimate", "executive"
        };
        String[] words3 = {
            "hello", "one", "even", "never",
            "now", "world", "draw"
        };
    }

    public int[] solution(int n, String[] words) {
        List<Word> tempWords = new ArrayList<>();
        lastWord = getLastWord(words[0]);

        for (int index = 0; index < words.length; index++) {
            tempWords.add(new Word(((index) % n) + 1, words[index], index + 1));
        }

        Queue<Word> queue = new LinkedList<>();
        for (int index = 0; index < words.length; index++) {
            queue.add(tempWords.get(index));
        }

        int startGroup = 1;
        while (!queue.isEmpty()) {
            Word word = queue.poll();
            if (word.isInvalidWord()) {
                return getAnswer(startGroup, word);
            }
            if (!word.startWith(lastWord)) {
                if (word.index == 1) {
                    lastWord = renewLastWord(getLastWord(word.word));
                    duplicatedWords.add(word.word);
                    continue;
                }
                return getAnswer(startGroup, word);
            }
            if (duplicatedWords.contains(word.word)) {
                return getAnswer(startGroup, word);
            }
            lastWord = renewLastWord(getLastWord(word.word));
            if (word.index % n == 0) {
                startGroup++;
            }
            duplicatedWords.add(word.word);
        }
        return new int[]{0, 0};
    }

    private int[] getAnswer(int startGrounp, Word word) {
        int[] answer = new int[2];
        answer[0] = word.id;
        answer[1] = startGrounp;
        return answer;
    }

    private String getLastWord(String word) {
        return String.valueOf(word.charAt(word.length() - 1));
    }

    private String renewLastWord(String word) {
        this.lastWord = word;
        return lastWord;
    }

    private class Word {

        int id;
        String word;
        int index;

        public Word(int id, String word, int index) {
            this.id = id;
            this.word = word;
            this.index = index;
        }

        public boolean isInvalidWord() {
            return this.word.length() == 1;
        }

        public boolean startWith(String word) {
            return this.word.startsWith(word);
        }
    }
}
