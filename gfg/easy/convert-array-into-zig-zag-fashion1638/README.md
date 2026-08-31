# Convert To Zig-Zag

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array arr of distinct elements, the task is to rearrange the elements of the array in a zig-zag fashion so that the converted array should be in the below form: 

arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] <.... arr[n-2] < arr[n-1] > arr[n]. 

Note: Modify the given arr[] only, If your transformation is correct, the output will be " **true"**  else the output will be  **"false"**. 

 **Examples** 

```
Input: arr[] = [4, 3, 7, 8, 6, 2, 1]
Output: true
Explanation:  After modification the array will look like 3 < 7 > 4 < 8 > 2 < 6 > 1, the checker in the driver code will produce 1.
```

```
Input: arr[] = [4, 7, 3, 8, 2]
Output: true
Explanation: After modification the array will look like 4 < 7 > 3 < 8 > 2 hence output will be 1.

```

```
Input: arr[] = [2, 8, 1, 7, 5, 9]
Output: true
```

 **Constraints:** 
1 <= arr.size() <= 106
0 <= arri <= 108

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T08:44:06.893Z  

```java
class Solution {
    public void zigZag(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            if (i % 2 == 0) {
                // arr[i] should be smaller than arr[i+1]
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                // arr[i] should be greater than arr[i+1]
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1)