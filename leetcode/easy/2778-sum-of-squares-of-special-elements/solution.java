class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        
        // Loop through 1-indexed positions
        for (int i = 1; i <= n; i++) {
            // Check if 'i' is a divisor of 'n'
            if (n % i == 0) {
                // Map the 1-indexed position 'i' to 0-indexed array position 'i - 1'
                int value = nums[i - 1];
                totalSum += value * value;
            }
        }
        
        return totalSum;
    }
}
