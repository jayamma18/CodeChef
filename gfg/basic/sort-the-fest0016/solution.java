import java.util.*;

class Solution {
    public static boolean commonString(String[] s, String[] t) {
        HashSet<String> set = new HashSet<>();

        for (String x : s) {
            set.add(x);
        }

        for (String x : t) {
            if (set.contains(x)) {
                return true;
            }
        }

        return false;
    }
}