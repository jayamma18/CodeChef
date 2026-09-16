import java.util.*;

class Solution {
    public static int countVowels(String s) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                set.add(ch);
            }
        }

        return set.size();
    }
}