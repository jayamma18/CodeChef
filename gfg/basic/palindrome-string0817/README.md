# Palindrome String

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**, find if it is a palindrome. A string is considered a palindrome if it reads the same forwards and backwards.

 **Examples :** 

```
Input: s = "abba"
Output: true
Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.
```

```
Input: s = "abc" 
Output: false
Explanation: "abc" does not read the same forwards and backwards, so it is not a palindrome.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:07:16.171Z  

```java
class Solution {
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Compare characters from both ends moving towards the center
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }

        return true; // All characters matched perfectly
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/palindrome-string0817/1)