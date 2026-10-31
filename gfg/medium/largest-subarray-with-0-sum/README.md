# Largest Subarray with 0 Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** containing both positive and negative integers, the task is to find the length of the longest subarray with a sum equals to 0.

 **Note:** A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

 **Examples:** 

```
Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
```

```
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
```

```
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:48:53.001Z  

```java
import java.util.HashMap;

class Solution {
    int maxLength(int arr[]) {
        // HashMap to store (prefix_sum, first_occurrence_index)
        HashMap<Integer, Integer> map = new HashMap<>();

        int max_len = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the sum from index 0 to i is 0
            if (sum == 0) {
                max_len = i + 1;
            }

            // If this prefix sum was already seen, a 0-sum subarray is found
            if (map.containsKey(sum)) {
                max_len = Math.max(max_len, i - map.get(sum));
            } else {
                // Store the first occurrence of this prefix sum
                map.put(sum, i);
            }
        }

        return max_len;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)