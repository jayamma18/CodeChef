# Good String

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**, find if it is good. A string is considered good if the cyclic distance between every pair of adjacent characters is exactly 1. 

-  The cyclic distance between two characters is the minimum distance in a circular arrangement of characters from 'a' to 'z'.  For example, the distance between 'a' and 'c' is 2 and he distance between 'a' and 'y' is 2. 
- A string of length 1 is always considered good.

 **Examples:** 

```
Input: s = "aaa"
Output: false
Explanation: distance between 'a' and 'a' is not 1.
```

```
Input: s = "cbc"
Output: true
Explanation: The distance between 'c' and 'b' is 1, and the distance between 'b' and 'c' is also 1.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:06:16.486Z  

```java
class Solution {
    public static boolean isGoodString(String s) {
        if (s.length() == 1) {
            return true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int diff = Math.abs(s.charAt(i) - s.charAt(i + 1));

            if (diff != 1 && diff != 25) {
                return false;
            }
        }

        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/good-string5712/1)