class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        
        // Find the absolute maximum and minimum in the entire array
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
            if (num < minVal) {
                minVal = num;
            }
        }
        
        // The optimal strategy is to pick the subarray containing both 
        // maxVal and minVal, and reuse it exactly k times.
        long maxSingleSubarrayValue = (long) maxVal - minVal;
        
        return maxSingleSubarrayValue * k;
    }
}
