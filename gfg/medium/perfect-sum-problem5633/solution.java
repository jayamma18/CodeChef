class Solution {
    static int perfectSum(int[] arr, int target) {
        int mod = 1000000007;
        int[] dp = new int[target + 1];

        // Base case: There is 1 way to form a sum of 0 (using an empty subset)
        dp[0] = 1;

        // Process each number in the array
        for (int num : arr) {
            // Traverse backward to ensure we use each element at most once (0/1 Knapsack style)
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % mod;
            }
        }

        return dp[target];
    }
}
