# Maximum Product Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

 **Note:**  It is guaranteed that the answer fits in a 32-bit integer.

**Examples
**

```
Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is [6, -3, -10] with product = 6  *(-3)*  (-10) = 180.
```

```
Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.
```

```
Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements. 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:09:24.937Z  

```java
class Solution {
    int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Initialize tracking variables with the first element
        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int overallMax = arr[0];

        // Traverse the array from the second element
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            // If the current element is negative, swap maxSoFar and minSoFar
            if (current < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Update max and min product ending at the current position
            maxSoFar = Math.max(current, maxSoFar * current);
            minSoFar = Math.min(current, minSoFar * current);

            // Update the global maximum product found so far
            overallMax = Math.max(overallMax, maxSoFar);
        }

        return overallMax;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1)