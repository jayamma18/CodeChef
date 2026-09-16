class Solution {
    public static boolean isStringExist(String s, String[] arr) {
        for (String x : arr) {
            if (x.length() != s.length()) {
                continue;
            }

            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != x.charAt(i)) {
                    count++;
                }
            }

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}