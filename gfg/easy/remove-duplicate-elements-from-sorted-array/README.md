# Remove Duplicates Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a sorted array  **arr[]** containing positive integers. Your task is to remove all duplicate elements from this array such that each element appears only once. Return an array containing these distinct elements in the same order as they appeared.

 **Examples :** 

```
Input: arr[] = [2, 2, 2, 2, 2]
Output: [2]
Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position and you should return array containing [2] after modifying the array.

```

```
Input: arr[] = [1, 2, 4]
Output: [1, 2, 4]
Explanation:  As the array does not contain any duplicates so you should return [1, 2, 4].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:54:17.887Z  

```java
import java.util.ArrayList;

class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        // Handle edge case for empty array
        if (arr == null || arr.length == 0) {
            return result;
        }

        // The first element is always distinct, so add it directly
        result.add(arr[0]);

        // Loop through the rest of the array
        for (int i = 1; i < arr.length; i++) {
            // If the current element is different from the previous one, it's unique
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }

        return result;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1)