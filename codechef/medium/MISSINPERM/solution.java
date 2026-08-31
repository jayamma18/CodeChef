class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0, sum2 = 0;

        // Sum of array elements
        for (int num : nums) {
            sum1 += num;
        }

        // Sum of numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            sum2 += i;
        }

        // Missing number is the difference
        return Math.abs(sum2 - sum1);
    }
}
