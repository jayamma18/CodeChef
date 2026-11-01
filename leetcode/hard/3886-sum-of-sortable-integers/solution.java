import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        
        // Step 1: Create a sorted version of the array to check multiset matches
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        // Step 2: Find all divisors of n
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        
        int totalSum = 0;
        
        // Used to track element frequencies to validate block contents efficiently
        int[] count = new int[100005];
        
        // Step 3: Check each divisor k
        for (int k : divisors) {
            boolean isValidk = true;
            
            for (int start = 0; start < n; start += k) {
                // 1. Check if the block is a valid cyclic shift of a sorted array
                int drops = 0;
                for (int i = 0; i < k; i++) {
                    int curr = nums[start + i];
                    int next = nums[start + (i + 1) % k];
                    if (curr > next) {
                        drops++;
                    }
                }
                
                if (drops > 1) {
                    isValidk = false;
                    break;
                }
                
                // 2. Check if the multiset elements match the sorted counterpart block
                for (int i = 0; i < k; i++) {
                    count[nums[start + i]]++;
                    count[sortedNums[start + i]]--;
                }
                
                // Verify all frequencies balanced back to 0
                for (int i = 0; i < k; i++) {
                    if (count[nums[start + i]] != 0 || count[sortedNums[start + i]] != 0) {
                        isValidk = false;
                    }
                }
                
                // Clean up frequency array for the next block
                for (int i = 0; i < k; i++) {
                    count[nums[start + i]] = 0;
                    count[sortedNums[start + i]] = 0;
                }
                
                if (!isValidk) {
                    break;
                }
            }
            
            if (isValidk) {
                totalSum += k;
            }
        }
        
        return totalSum;
    }
}
