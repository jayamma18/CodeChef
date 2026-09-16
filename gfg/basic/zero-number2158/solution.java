class Solution {
    public static boolean check_duck(String N) {
        int i = 0;

        while (i < N.length() && N.charAt(i) == '0') {
            i++;
        }

        for (; i < N.length(); i++) {
            if (N.charAt(i) == '0') {
                return true;
            }
        }

        return false;
    }
}