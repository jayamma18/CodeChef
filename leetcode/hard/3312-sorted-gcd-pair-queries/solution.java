import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // count[i] will store how many numbers in nums are divisible by i
        long[] count = new long[maxVal + 1];
        for (int num : nums) {
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    count[i]++;
                    if (i * i != num) {
                        count[num / i]++;
                    }
                }
            }
        }

        // gcdCount[i] will store exactly how many pairs have gcd == i
        long[] gcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalMultiples = count[i];
            long pairs = totalMultiples * (totalMultiples - 1) / 2;
            
            // Subtract pairs that have a larger multiple of i as their actual GCD
            for (int j = 2 * i; j <= maxVal; j += i) {
                pairs -= gcdCount[j];
            }
            gcdCount[i] = pairs;
        }

        // Build prefix sum of GCD pair frequencies
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + gcdCount[i];
        }

        // Process queries using binary search
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = binarySearch(prefixSum, queries[i]);
        }

        return answer;
    }

    private int binarySearch(long[] prefixSum, long queryVal) {
        int low = 1, high = prefixSum.length - 1;
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] > queryVal) {
                ans = mid;
                high = mid - 1; // Try to look for a smaller valid GCD index
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
