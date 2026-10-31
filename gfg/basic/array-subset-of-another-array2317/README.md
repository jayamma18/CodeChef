# Array Subset

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given two arrays  **a[]** and  **b[]**, your task is to determine whether  **b[]**  is a subset of  **a[]**.

 **Examples:** 

```
Input: a[] = [11, 7, 1, 13, 21, 3, 7, 3], b[] = [11, 3, 7, 1, 7]
Output: true
Explanation: b[] is a subset of a[]
```

```
Input: a[] = [1, 2, 3, 4, 4, 5, 6], b[] = [1, 2, 4]
Output: true
Explanation: b[] is a subset of a[]
```

```
Input: a[] = [10, 5, 2, 23, 19], b[] = [19, 5, 3]
Output: false
Explanation: b[] is not a subset of a[]
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:53:21.475Z  

```java
import java.util.HashMap;

class Solution {
    public boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies of each element in array a[]
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Verify if elements of array b[] exist with adequate frequency in a[]
        for (int num : b) {
            // If the element is missing or its available count is 0, b is not a subset
            if (!map.containsKey(num) || map.get(num) == 0) {
                return false;
            }
            // Decrement the frequency count for the matched element
            map.put(num, map.get(num) - 1);
        }

        return true;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1)