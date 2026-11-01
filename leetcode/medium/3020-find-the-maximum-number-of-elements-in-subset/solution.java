import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put((long) num, counts.getOrDefault((long) num, 0) + 1);
        }

        int maxLength = 1; // Any single element can form a valid sequence of length 1

        // Handle the edge case for 1s
        if (counts.containsKey(1L)) {
            int oneCount = counts.get(1L);
            // Must be an odd length to follow the pattern [1, 1, 1]
            if (oneCount % 2 == 0) {
                maxLength = Math.max(maxLength, oneCount - 1);
            } else {
                maxLength = Math.max(maxLength, oneCount);
            }
        }

        // Process other keys as potential starting bases
        for (long x : counts.keySet()) {
            if (x == 1) continue;

            int currentLength = 0;
            long currentNum = x;

            // Follow the squaring chain while we have at least 2 copies of the number
            while (counts.containsKey(currentNum) && counts.get(currentNum) >= 2) {
                currentLength += 2;
                
                // Guard against potential overflow before squaring
                if (currentNum > 100000) { 
                    currentNum = Long.MAX_VALUE; // Sentinel to break loop
                    break;
                }
                currentNum = currentNum * currentNum;
            }

            // If the next squared number exists at least once, it can be the peak
            if (counts.containsKey(currentNum)) {
                currentLength += 1;
            } else {
                // If it doesn't exist, our last element must act as the peak instead
                currentLength -= 1; 
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
