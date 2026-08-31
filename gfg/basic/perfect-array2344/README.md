# Check for Bitonic with Same Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array  **arr[]**  of non-negative integers, determine whether the array is perfect. An array is considered perfect if it first strictly increases, then remains constant, and finally strictly decreases. Any of these three parts can be empty.

### Examples:

```
Input: arr[] = [1, 8, 8, 8, 3, 2]
Output: true
Explanation: The array [1, 8, 8, 8, 3, 2] first increases in the range [0, 1], stays constant in the range [1, 3], and then decreases in the range [3, 4]. Thus, the array is perfect.
```

```
Input: arr[] = [1, 1, 2, 2, 1]
Output: false
Explanation: The array does not follow the required pattern of strictly increasing, constant, and then strictly decreasing.
```

 **Constraints** 
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 108

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T10:11:22.537Z  

```java
class Solution {
    // gfg calls different names, so added all
    public boolean isPerfect(int[] arr) {
        return solve(arr);
    }
    public boolean isBitonic(int[] arr) {
        return solve(arr);
    }
    public boolean checkPerfect(int[] arr) {
        return solve(arr);
    }

    private boolean solve(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true; // 0,1,2 elements always perfect

        int state = 0; // 0 = increasing, 1 = constant, 2 = decreasing

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                if (state == 0) state = 1; // inc -> const allowed
                else if (state == 2) return false; // dec -> const NOT allowed
                // state 1 -> 1 allowed
            }
            else if (arr[i] > arr[i-1]) {
                if (state == 1 || state == 2) return false; // const/dec -> inc NOT allowed
                // state 0 -> 0 allowed
            }
            else { // arr[i] < arr[i-1]
                if (state == 0 || state == 1) state = 2; // inc/const -> dec allowed
                // state 2 -> 2 allowed
            }
        }
        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/perfect-array2344/1)