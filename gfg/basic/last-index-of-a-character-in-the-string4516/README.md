# Last index of a character

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**  of size  **n**  and a character  **c**, find the last index (0-based indexing) of c in s. If the character is not present, return -1. Both s and c contain only lowercase and uppercase English alphabets.

 **Examples:** 

```
Input: s = "Geeks", c = 'e'
Output: 2
Explanation: The last occurrence of 'e' is at index 2.

```

```
Input: s = "okiyh", c = 'z'
Output: -1
Explanation: The character 'z' is not present in the string.
```

 **Constraints:** 
1 ≤ n ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:18:46.575Z  

```java
class Solution {
    public int LastIndex(String s, char c) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/last-index-of-a-character-in-the-string4516/1)