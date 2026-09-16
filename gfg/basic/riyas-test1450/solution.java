class Solution {
    public static boolean halvesMatch(String s) {
        int n = s.length();
        int mid = n / 2;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < mid; i++) {
            freq1[s.charAt(i) - 'a']++;
        }

        for (int i = n - mid; i < n; i++) {
            freq2[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}