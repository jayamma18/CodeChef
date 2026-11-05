class Solution {
    public int countNonMinimum(int[] nums) {
        if (nums.length == 0) return 0;

        int minimum = nums[0];
        int countMin = 0;

        // Find the minimum value in the array
        for (int num : nums) {
            if (num < minimum) {
                minimum = num;
            }
        }

        // Count how many times the minimum value appears
        for (int num : nums) {
            if (num == minimum) {
                countMin++;
            }
        }

        // The number of operations needed is the total elements minus the count of the minimum
        return nums.length - countMin;
    }
}