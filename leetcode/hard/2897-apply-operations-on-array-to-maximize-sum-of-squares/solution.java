import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        // Since elements go up to 10^9, we need 30 bits to cover all values (2^30 > 10^9)
        int[] bitCounts = new int[30];
        
        // Count the occurrences of each bit across all numbers
        for (int num : nums) {
            for (int bit = 0; bit < 30; bit++) {
                if (((num >> bit) & 1) == 1) {
                    bitCounts[bit]++;
                }
            }
        }
        
        long totalSumSquare = 0;
        long MOD = 1_000_000_007;
        
        // Greedily construct the k largest possible numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            
            for (int bit = 0; bit < 30; bit++) {
                // If there are remaining 1-bits for this position, pull one into our current number
                if (bitCounts[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCounts[bit]--; // Consume the bit
                }
            }
            
            // Add the square of our optimally packed number to the modulo tracker
            totalSumSquare = (totalSumSquare + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSumSquare;
    }
}
