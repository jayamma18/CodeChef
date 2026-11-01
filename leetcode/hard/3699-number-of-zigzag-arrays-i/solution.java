class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1000000007;
        int k = r - l + 1;
        
        // Base case: for n = 1, there's 1 way for each number, but zigzag rules apply for lengths >= 2.
        // We will initialize the DP table directly for length 2.
        long[][] dp = new long[k][2];
        
        // For length 2:
        // dp[v][0] means decreased to v (so previous u > v). There are (k - 1 - v) such elements.
        // dp[v][1] means increased to v (so previous u < v). There are v such elements.
        for (int v = 0; v < k; v++) {
            dp[v][0] = (k - 1 - v);
            dp[v][1] = v;
        }
        
        // Iteratively process lengths from 3 up to n
        for (int i = 3; i <= n; i++) {
            long[][] nextDp = new long[k][2];
            
            // Optimize transitions using running Prefix and Suffix Sums
            long prefixSum0 = 0; // Tracks sum of dp[u][0] for u < v
            long suffixSum1 = 0; // Tracks sum of dp[u][1] for u > v
            
            // Calculate suffix sums first for dp[u][1] to easily transition to nextDp[v][0]
            for (int u = k - 1; u >= 0; u--) {
                nextDp[u][0] = suffixSum1;
                suffixSum1 = (suffixSum1 + dp[u][1]) % MOD;
            }
            
            // Calculate prefix sums next for dp[u][0] to transition to nextDp[v][1]
            for (int u = 0; u < k; u++) {
                nextDp[u][1] = prefixSum0;
                prefixSum0 = (prefixSum0 + dp[u][0]) % MOD;
            }
            
            dp = nextDp;
        }
        
        // Total sum of all valid configurations of length n
        long totalWays = 0;
        for (int v = 0; v < k; v++) {
            totalWays = (totalWays + dp[v][0] + dp[v][1]) % MOD;
        }
        
        return (int) totalWays;
    }
}
