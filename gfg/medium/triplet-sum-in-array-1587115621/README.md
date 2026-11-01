# Triplet Sum in Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  and an integer  **target**, determine if there exists a triplet in the array whose sum equals the given  **target**.

Return  **true**  if such a triplet exists, otherwise, return  **false**.

**Examples: 
**

```
Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
Output: true 
Explanation: The triplet {1, 4, 8} sums up to 13.
```

```
Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10
Output: true 
Explanation: The triplets {1, 3, 6} and {1, 2, 7} both sum to 10. 
```

```
Input: arr[] = [40, 20, 10, 3, 6, 7], target = 24
Output: false 
Explanation: No triplet in the array sums to 24.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:47:47.644Z  

```java
import java.util.Arrays;

class Solution {
    // Function to find if there exists a triplet in the array whose sum equals the given target.
    public boolean hasTripletSum(int[] arr, int target) {
        int n = arr.length;

        // Step 1: Sort the array to utilize the two-pointer technique
        Arrays.sort(arr);

        // Step 2: Fix the first element of the triplet one by one
        for (int i = 0; i < n - 2; i++) {

            // Initialize two pointers for the remaining part of the array
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    return true; // Triplet found
                } else if (currentSum < target) {
                    left++; // Need a larger sum, move left pointer right
                } else {
                    right--; // Need a smaller sum, move right pointer left
                }
            }
        }

        return false; // No triplet found
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1)