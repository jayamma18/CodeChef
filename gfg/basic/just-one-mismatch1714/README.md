# Just One Mismatch

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**  and an array of strings  **arr[]**, find if any string in arr[] of the same length as s differs from it at exactly one position. 

 **Examples:** 

```
Input: arr[] = ["bana", "apple", "banaba", "bonaba"], s = "banana"
Output: true
Explanation: "banana" and "banaba" have the same length and differ at exactly one position.
```

```
Input: arr[] = ["bana", "apple", "banaba", "bonanzo"], s = "apple"
Output: false
Explanation: No string in the array differs from "apple" by exactly one character.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T05:52:34.129Z  

```java
class Solution {
    public static boolean isStringExist(String s, String[] arr) {
        for (String x : arr) {
            if (x.length() != s.length()) {
                continue;
            }

            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != x.charAt(i)) {
                    count++;
                }
            }

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/just-one-mismatch1714/1)