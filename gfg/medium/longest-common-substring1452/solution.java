class Solution {
    // GeeksforGeeks driver code expects this exact method name
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // dp array to store results of the previous row
        int[] dp = new int[m + 1];
        int maxLength = 0;

        for (int i = 1; i <= n; i++) {
            // Traverse backwards to prevent overwriting values needed for the current row
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    // Substring continuity is broken, reset to 0
                    dp[j] = 0;
                }
            }
        }

        return maxLength;
    }
}
