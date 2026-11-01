import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long totalScore = 0;
        
        // Convert elements to their absolute values because squaring ignores the sign
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        // Sort in ascending order of absolute values
        Arrays.sort(nums);
        
        // The first n / 2 elements are the smallest and should be subtracted (at odd positions)
        int subtractCount = n / 2;
        
        for (int i = 0; i < n; i++) {
            long squaredVal = (long) nums[i] * nums[i];
            
            if (i < subtractCount) {
                totalScore -= squaredVal; // Assign to negative/subtraction terms
            } else {
                totalScore += squaredVal; // Assign to positive/addition terms
            }
        }
        
        return totalScore;
    }
}
