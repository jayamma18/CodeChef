# Equalize Array Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given an array  **arr[]**  of positive integers. In one operation, choose any two unequal elements and replace the larger element with the difference of the two elements. Repeat this process until all elements become equal. Return the final common value.

 **Examples:** 

```
Input: arr[] = [10, 12]
Output: 2
Explanation: The array changes as: [10, 12] -> [10, 2] -> [8, 2] -> [6, 2] -> [4, 2] -> [2, 2]. Hence, the final common value is 2.
```

```
Input: arr[] = [6, 10, 15]
Output: 1
Explanation: One possible sequence of operations is: [6, 10, 15] -> [6, 10, 9] -> [6, 4, 9] -> [6, 4, 3] -> [2, 4, 3] -> [2, 4, 1] -> [2, 2, 1] -> [1, 2, 1] -> [1, 1, 1]. Hence, the final common value is 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T08:31:36.218Z  

```java
class Solution {
    public int equalLength(int[] arr) {
        // The process of replacing a number with its difference 
        // mimics the Euclidean algorithm for finding the GCD.
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            
            // Optimization: If GCD reaches 1, it cannot go any lower
            if (result == 1) {
                return 1;
            }
        }
        
        return result;
    }
    
    // Helper function to calculate GCD using the optimal Euclidean method
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/chocolate-lengths0332/1)