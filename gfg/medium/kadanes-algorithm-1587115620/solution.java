class Solution {
    int maxSubarraySum(int[] arr) {
        // Stores the maximum subarray sum found so far
        int res = arr[0]; 
        
        // Stores the maximum sum of the subarray ending at the current position
        int maxEnding = arr[0]; 
        
        for (int i = 1; i < arr.length; i++) {
            // Either extend the previous subarray or start a new one from the current element
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            
            // Update the overall maximum result if the current subarray sum is larger
            res = Math.max(res, maxEnding);
        }
        
        return res;
    }
}
