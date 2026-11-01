import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Custom wrapper to keep track of the original index and calculated digit sum
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i, getDigitSum(nums[i]));
        }
        
        // Sort based on the custom criteria
        Arrays.sort(elements, (a, b) -> {
            if (a.digitSum != b.digitSum) {
                return Integer.compare(a.digitSum, b.digitSum);
            }
            return Integer.compare(a.val, b.val);
        });
        
        // Track visited elements to count graph cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position, skip
            if (visited[i] || elements[i].originalIndex == i) {
                continue;
            }
            
            // Calculate size of the cycle
            int cycleSize = 0;
            int curr = i;
            
            while (!visited[curr]) {
                visited[curr] = true;
                curr = elements[curr].originalIndex;
                cycleSize++;
            }
            
            // A cycle of size K requires K - 1 swaps
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    // Helper function to extract digit sum
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    // Class helper structure
    private static class Element {
        int val;
        int originalIndex;
        int digitSum;
        
        Element(int val, int originalIndex, int digitSum) {
            this.val = val;
            this.originalIndex = originalIndex;
            this.digitSum = digitSum;
        }
    }
}
