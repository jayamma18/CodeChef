# Average Count Array

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an integer array  **arr[]**  and an integer  **x**. Do the following steps for for each index i (0-based),

- Calculate the floor value of the average of arr[i] and x:  avg = floor((arr[i] + x) / 2). 
- Count how many times this calculated value occurs in the original array arr[]. 
- Store this count at index i of a new array result[].

Return the array result[].

 **Examples:** 

```
Input: arr[] = [2, 4, 8, 6, 2], x = 2
Output: [2, 0, 0, 1, 2]
Explanation: For each element,
arr[0] = 2: floor((2 + 2) / 2) = 2. Value 2 appears 2 times.
arr[1] = 4: floor((4 + 2) / 2) = 3. Value 3 does not appear,.
arr[2] = 8: floor((8 + 2) / 2) = 5. Value 5 does not appear.
arr[3] = 6: floor((6 + 2) / 2) = 4. Value 4 appears once.
arr[4] = 2: floor((2 + 2) / 2) = 2. Value 2 appears 2 times.
```

```
Input : arr[] = [9, 5, 2, 4, 0, 3], x = 3 
Output : [0, 1, 1, 1, 0, 1] 
Explanation: The calculated average values are: [6, 4, 2, 3, 1, 3]
Their frequencies in arr[] are: [0, 1, 1, 1, 0, 1]
```

 **Constraints:** 
1 ≤ arr.size() ≤ 105
0 ≤ x ≤ 105
0 ≤ arr[i] ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T10:07:32.840Z  

```java
import java.util.*;

class Solution {
    public int[] countArray(int[] arr, int x) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int avg = (arr[i] + x) / 2;
            res[i] = freq.getOrDefault(avg, 0);
        }
        return res;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/average-count-array2215/1)