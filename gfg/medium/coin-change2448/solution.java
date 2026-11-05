class Solution {
    public int count(int[] coins, int sum) {
        // dp[i] will store the number of ways to make change for amount i
        int[] dp = new int[sum + 1];

        // Base case: There is 1 way to make a sum of 0 (by choosing no coins)
        dp[0] = 1;

        // Pick all coins one by one and update the dp[] values
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }
}
