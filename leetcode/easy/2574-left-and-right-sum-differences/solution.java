class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Calculate the total sum of the entire array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // rightSum for index i is totalSum minus leftSum minus the current element
            int rightSum = totalSum - leftSum - nums[i];
            
            // Calculate absolute difference
            answer[i] = Math.abs(leftSum - rightSum);
            
            // Update leftSum to include the current element for the next iteration
            leftSum += nums[i];
        }
        
        return answer;
    }
}
