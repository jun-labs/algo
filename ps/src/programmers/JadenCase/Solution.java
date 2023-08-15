package programmers.JadenCase;

public class Solution {

    public String solution(String s) {
        String[] array = s.split(" ", -1);
        for (int index = 0; index < array.length; index++) {
            String element = array[index].toLowerCase();
            String[] eachElement = element.split("");
            String changeFirstLetter = eachElement[0].toUpperCase();
            eachElement[0] = changeFirstLetter;
            String word = String.join("", eachElement);
            array[index] = word;
        }
        return String.join(" ", array);
    }
}
