# Sorted GCD Pair Queries

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` of length `n` and an integer array `queries`.

Let `gcdPairs` denote an array obtained by calculating the GCD of all possible pairs `(nums[i], nums[j])`, where `0 <= i < j < n`, and then sorting these values in  **ascending**  order.

For each query `queries[i]`, you need to find the element at index `queries[i]` in `gcdPairs`.

Return an integer array `answer`, where `answer[i]` is the value at `gcdPairs[queries[i]]` for each query.

The term `gcd(a, b)` denotes the  **greatest common divisor**  of `a` and `b`.

 

 **Example 1:** 

 **Input:**  nums = [2,3,4], queries = [0,2,2]

 **Output:**  [1,2,2]

 **Explanation:** 

`gcdPairs = [gcd(nums[0], nums[1]), gcd(nums[0], nums[2]), gcd(nums[1], nums[2])] = [1, 2, 1]`.

After sorting in ascending order, `gcdPairs = [1, 1, 2]`.

So, the answer is `[gcdPairs[queries[0]], gcdPairs[queries[1]], gcdPairs[queries[2]]] = [1, 2, 2]`.

 **Example 2:** 

 **Input:**  nums = [4,4,2,1], queries = [5,3,1,0]

 **Output:**  [4,2,1,1]

 **Explanation:** 

`gcdPairs` sorted in ascending order is `[1, 1, 1, 2, 2, 4]`.

 **Example 3:** 

 **Input:**  nums = [2,2], queries = [0,0]

 **Output:**  [2,2]

 **Explanation:** 

`gcdPairs = [2]`.

 

 **Constraints:** 

- 2 <= n == nums.length <= 105
- 1 <= nums[i] <= 5 * 104
- 1 <= queries.length <= 105
- 0 <= queries[i] < n * (n - 1) / 2

## Solution

**Language:** Java  
**Runtime:** 111 ms (beats 10.58%)  
**Memory:** 102.1 MB (beats 56.08%)  
**Submitted:** 2026-11-01T12:12:09.774Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/sorted-gcd-pair-queries/)