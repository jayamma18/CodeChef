import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        
        int maxVal = 0;
        
        // 1. Build the prefixGcd array
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxVal);
        }
        
        // 2. Sort the generated values
        Arrays.sort(prefixGcd);
        
        long totalGcdSum = 0;
        int left = 0;
        int right = n - 1;
        
        // 3. Two pointers to combine the smallest and largest unpaired values
        while (left < right) {
            totalGcdSum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        
        return totalGcdSum;
    }
    
    // Standard Euclidean algorithm for finding the greatest common divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
