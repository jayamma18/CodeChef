# Check Triplet With 0 Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of integers, find if it contains a triplet whose sum equals zero.

 **Examples:** 

```
Input: arr[] = [0, -1, 2, -3, 1]
Output: true
Explanation: The triplet [0, -1, 1] has a sum equal to zero.
```

```
Input: arr[] = [1, 2, 3]
Output: false
Explanation: No triplet with a sum of zero exists.
```

```
Input: arr[] = [-5, 3, 2, -1, 0, 1]
Output: true
Explanation: The triplet [-5, 3, 2] has a sum equal to zero.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:50:45.661Z  

```java
import java.util.Arrays;

class Solution {
    // Function to check if a triplet with a sum equal to zero exists in the array.
    public boolean findTriplets(int[] arr) {
        int n = arr.length;

        // Step 1: Sort the array to implement the two-pointer technique
        Arrays.sort(arr);

        // Step 2: Fix the first element of the triplet one by one
        for (int i = 0; i < n - 2; i++) {

            // Initialize two pointers for the remaining part of the array
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == 0) {
                    return true; // Triplet found whose sum is 0
                } else if (currentSum < 0) {
                    left++; // Sum is too small, move left pointer right
                } else {
                    right--; // Sum is too large, move right pointer left
                }
            }
        }

        return false; // No such triplet exists
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1)