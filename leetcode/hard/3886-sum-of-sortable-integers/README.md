# Sum of Sortable Integers

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` of length `n`.

An integer `k` is called  **sortable**  if `k`  **divides**  `n` and you can sort `nums` in  **non-decreasing**  order by sequentially performing the following operations:

- Partition nums into consecutive subarrays of length k.
- Cyclically rotate each subarray independently any number of times to the left or to the right.

Return an integer denoting the sum of all possible sortable integers `k`.

 

 **Example 1:** 

 **Input:**  nums = [3,1,2]

 **Output:**  3

 **Explanation:** ​​​​​​​

- For n = 3, possible divisors are 1 and 3.
- For k = 1: each subarray has one element. No rotation can sort the array.
- For k = 3: the single subarray [3, 1, 2] can be rotated once to produce [1, 2, 3], which is sorted.
- Only k = 3 is sortable. Hence, the answer is 3.

 **Example 2:** 

 **Input:**  nums = [7,6,5]

 **Output:**  0

 **Explanation:** 

- For n = 3, possible divisors are 1 and 3.
- For k = 1: each subarray has one element. No rotation can sort the array.
- For k = 3: the single subarray [7, 6, 5] cannot be rotated into non-decreasing order.
- No k is sortable. Hence, the answer is 0.

 **Example 3:** 

 **Input:**  nums = [5,8]

 **Output:**  3

 **Explanation:** ​​​​​​​

- For n = 2, possible divisors are 1 and 2.
- Since [5, 8] is already sorted, every divisor is sortable. Hence, the answer is 1 + 2 = 3.

 

 **Constraints:** 

- 1 <= n == nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 194 ms (beats 5.49%)  
**Memory:** 78.9 MB (beats 20.73%)  
**Submitted:** 2026-11-01T11:40:11.134Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-sortable-integers/)