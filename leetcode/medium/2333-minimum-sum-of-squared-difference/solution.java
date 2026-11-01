class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        
        // Find the maximum possible absolute difference to size our bucket array
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums1[i] - nums2[i]));
        }
        
        // If maxDiff is 0, the arrays are already identical
        if (maxDiff == 0) {
            return 0;
        }
        
        // bucket[d] stores how many pairs have an absolute difference equal to 'd'
        long[] bucket = new long[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            bucket[Math.abs(nums1[i] - nums2[i])]++;
        }
        
        // Greedily reduce the largest differences down to smaller layers
        for (int d = maxDiff; d > 0; d--) {
            if (bucket[d] == 0) {
                continue;
            }
            
            // If our total modifications 'k' can cover reducing all elements at this difference level
            if (k >= bucket[d]) {
                k -= bucket[d];
                bucket[d - 1] += bucket[d]; // They all get reduced to a difference of (d - 1)
                bucket[d] = 0;
            } else {
                // Otherwise, use up all remaining 'k' modifications to reduce a portion of them
                bucket[d - 1] += k;
                bucket[d] -= k;
                k = 0;
                break; // No more modifications left
            }
        }
        
        // Calculate the final minimum sum of squared differences
        long minSumSquare = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (bucket[d] > 0) {
                minSumSquare += bucket[d] * (long) d * d;
            }
        }
        
        return minSumSquare;
    }
}
