class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        boolean isSorted = true;
        
        // Initialize mask with all bits set (equivalent to ~0 or -1 in binary)
        int maxK = -1; 
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                isSorted = false;
                
                // The common k must satisfy the bit structure of both the value and its destination index
                maxK &= nums[i];
                maxK &= i;
            }
        }
        
        // If the array is already sorted initially, return 0 as per the instructions
        return isSorted ? 0 : maxK;
    }
}
