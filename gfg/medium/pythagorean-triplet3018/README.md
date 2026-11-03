# Pythagorean Triplet

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**, return true if there is a  **triplet (a, b, c)**  from the array (where a, b, and c are on different indexes) that satisfies  **a2 + b2 = c2**, otherwise return false.

 **Examples:** 

```
Input: arr[] = [3, 2, 4, 6, 5]
Output: true
Explanation: a=3, b=4, and c=5 forms a pythagorean triplet.

```

```
Input: arr[] = [3, 8, 5]
Output: false
Explanation: No such triplet possible.
```

```
Input: arr[] = [1, 1, 1]
Output: false
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T14:03:13.282Z  

```java
class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // Step 1: Find the maximum element in the array to size our frequency tracker
        int maxElem = 0;
        for (int num : arr) {
            if (num > maxElem) {
                maxElem = num;
            }
        }

        // Step 2: Record the frequency of each element
        int[] hash = new int[maxElem + 1];
        for (int num : arr) {
            hash[num]++;
        }

        // Step 3: Iterate through all possible pairs of elements up to maxElem
        for (int i = 1; i <= maxElem; i++) {
            // If the first number 'i' doesn't exist in the array, skip it
            if (hash[i] == 0) continue;

            for (int j = 1; j <= maxElem; j++) {
                // If the second number 'j' doesn't exist, skip it
                if (hash[j] == 0) continue;

                // Handle the special case where a and b are the same number (e.g., 3^2 + 3^2 = c^2)
                // We need at least two copies of this number in the array
                if (i == j && hash[i] < 2) continue;

                // Calculate the required c^2 value
                int cSq = (i * i) + (j * j);
                int c = (int) Math.sqrt(cSq);

                // Check if 'c' is a perfect square and actually exists in our hash array
                if (c * c == cSq && c <= maxElem && hash[c] > 0) {
                    return true;
                }
            }
        }

        return false;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1)