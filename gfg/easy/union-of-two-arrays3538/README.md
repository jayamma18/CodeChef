# Union of Arrays with Duplicates

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given two arrays  **a[]**  and  **b[]**, return the union of both the arrays in any order. 

- Elements of a[] and b[] are not necessarily distinct, but output should have only distinct elements.
- The returned union may have elements in any order, the driver code will print the result in sorted order only.

 **Examples:** 

```
Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
Output: [1, 2, 3]
Explanation: Union set of both the arrays will be 1, 2 and 3.

```

```
Input: a[] = [1, 2, 3], b[] = [4, 5, 6] 
Output: [1, 2, 3, 4, 5, 6]
Explanation: Union set of both the arrays will be 1, 2, 3, 4, 5 and 6.
```

```
Input: a[] = [1, 2, 1, 1, 2], b[] = [2, 2, 1, 2, 1] 
Output: [1, 2]
Explanation: Union set of both the arrays will be 1 and 2.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:35:19.247Z  

```java
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;

        // Step 2: Use two pointers to traverse both arrays simultaneously
        while (i < a.length && j < b.length) {
            // Skip duplicate elements in array 'a'
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicate elements in array 'b'
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                addUnique(result, a[i]);
                i++;
            } else if (b[j] < a[i]) {
                addUnique(result, b[j]);
                j++;
            } else {
                addUnique(result, a[i]);
                i++;
                j++;
            }
        }

        // Process remaining elements of array 'a'
        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                addUnique(result, a[i]);
            }
            i++;
        }

        // Process remaining elements of array 'b'
        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                addUnique(result, b[j]);
            }
            j++;
        }

        return result;
    }

    // Helper function to prevent duplicates from consecutive additions
    private static void addUnique(ArrayList<Integer> list, int val) {
        if (list.isEmpty() || list.get(list.size() - 1) != val) {
            list.add(val);
        }
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1)