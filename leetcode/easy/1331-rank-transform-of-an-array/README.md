# Rank Transform of an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of integers `arr`, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

- Rank is an integer starting from 1.
- The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
- Rank should be as small as possible.

 

 **Example 1:** 

```
Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
```

 **Example 2:** 

```
Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.

```

 **Example 3:** 

```
Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]

```

 

 **Constraints:** 

- 0 <= arr.length <= 105
- -109 <= arr[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 31 ms (beats 60.25%)  
**Memory:** 74.8 MB (beats 75.87%)  
**Submitted:** 2026-11-01T11:57:44.813Z  

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // 1. Create a copy and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // 2. Assign unique ranks to each element using a Map
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // 3. Transform the original array into its ranks
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/rank-transform-of-an-array/)