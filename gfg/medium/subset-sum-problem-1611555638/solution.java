class Solution {
    // Function to check if a subset with the given sum exists
    static Boolean isSubsetSum(int[] arr, int sum) {
        // dp[i] will store whether a sum of 'i' is possible
        boolean[] dp = new boolean[sum + 1];

        // Base case: A sum of 0 is always possible (by picking an empty subset)
        dp[0] = true;

        // Iterate through all items in the array
        for (int num : arr) {
            // Traverse backward to ensure we don't use the same element multiple times
            for (int j = sum; j >= num; j--) {
                // If a sum of (j - num) was possible, then a sum of j is also possible
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }
}
