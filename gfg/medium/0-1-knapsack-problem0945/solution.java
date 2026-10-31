class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        // dp[w] stores the maximum value achievable with a knapsack capacity of w
        int[] dp = new int[W + 1];

        // Process each item one by one
        for (int i = 0; i < n; i++) {
            // Traverse backward from capacity W down to the weight of the current item
            // This ensures each item is used at most once
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }
}
