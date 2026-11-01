class Solution {
    // GeeksforGeeks driver code expects an int return type
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        long currentWindowSum = 0;

        // Step 1: Compute the sum of the first window of size k
        for (int i = 0; i < k; i++) {
            currentWindowSum += arr[i];
        }

        long maxSum = currentWindowSum;

        // Step 2: Slide the window from index k to the end of the array
        for (int i = k; i < n; i++) {
            // Add the new element entering the window and subtract the one leaving it
            currentWindowSum += arr[i] - arr[i - k];

            // Track the maximum sum found so far
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        // Cast the final result back to int to match the expected return type
        return (int) maxSum;
    }
}
