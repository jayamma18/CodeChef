# Union of 2 Sorted Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two sorted arrays  **a[]**  and  **b[]**, where each array may contain duplicate elements, the task is to return the elements in the union of the two arrays in sorted order. Union of two arrays can be defined as the set containing distinct elements that are present in either of the arrays.

 **Examples:** 

```
Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: [1, 2, 3, 4, 5, 6, 7]
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
```

```
Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: [1, 2, 3, 4, 5]
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
```

```
Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
Output: [1, 2]
Explanation: Distinct elements including both the arrays are: 1 2.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:04:20.794Z  

```java
import java.util.ArrayList;

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length;
        int m = b.length;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                // Add a[i] if it's the first element or not a duplicate
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
            } else if (b[j] < a[i]) {
                // Add b[j] if it's the first element or not a duplicate
                if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                    result.add(b[j]);
                }
                j++;
            } else {
                // Both are equal, add either and increment both pointers
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
            }
        }

        // Process remaining elements of array a[]
        while (i < n) {
            if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }

        // Process remaining elements of array b[]
        while (j < m) {
            if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1)