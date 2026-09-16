import java.util.*;

class Solution {
    public static ArrayList<Integer> wordLengths(String s) {
        ArrayList<Integer> result = new ArrayList<>();

        String[] words = s.split(" ");

        for (String word : words) {
            result.add(word.length());
        }

        return result;
    }
}