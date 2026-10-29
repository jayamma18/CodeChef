# Duplicates in Limited Range Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array  **arr[]**  of size **n**, containing elements from the range  **1** to **n**, and each element appears at most  **twice**, return an array of all the integers that appears twice.

 **Note:**  You can return the elements in any order but the driver code will print them in sorted order.

 **Examples:** 

```
Input: arr[] = [2, 3, 1, 2, 3]
Output: [2, 3] 
Explanation: 2 and 3 occur more than once in the given array.
```

```
Input: arr[] = [3, 1, 2] 
Output: []
Explanation: There is no repeating element in the array, so the output is empty.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T09:01:00.077Z  

```java
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Get the original value (using absolute value since it might have been negated)
            int val = Math.abs(arr[i]);

            // Map the value to a 0-based index
            int index = val - 1;

            // If the element at this index is already negative, we've seen this value before
            if (arr[index] < 0) {
                result.add(val);
            } else {
                // Otherwise, mark the element at this index as visited by negating it
                arr[index] = -arr[index];
            }
        }

        return result;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1)