class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        // Check every possible subarray starting at index i
        for (int i = 0; i < n; i++) {
            int balance = 0;
            for (int j = i; j < n; j++) {
                // If it matches target, increment balance, else decrement
                if (nums[j] == target) {
                    balance++;
                } else {
                    balance--;
                }

                // If balance > 0, target is strictly the majority element
                if (balance > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
