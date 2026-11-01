import java.util.List;
import java.util.HashSet;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        
        // Iterate through all possible starting indices of the subarray
        for (int i = 0; i < n; i++) {
            HashSet<Integer> distinctElements = new HashSet<>();
            
            // Expand the subarray from index i to j
            for (int j = i; j < n; j++) {
                distinctElements.add(nums.get(j));
                
                // Get the size of distinct elements and add its square to the total
                int distinctCount = distinctElements.size();
                totalSum += distinctCount * distinctCount;
            }
        }
        
        return totalSum;
    }
}
