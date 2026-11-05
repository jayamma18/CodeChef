# Valid Anagram

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  s = "anagram", t = "nagaram"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "rat", t = "car"

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length, t.length <= 5 * 104
- s and t consist of lowercase English letters.

 

 **Follow up:**  What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 41.8 MB  
**Submitted:** 2026-11-05T09:52:12.353Z  

```java
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        // Sort both arrays alphabeticaly
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        // If sorted arrays are identical, it is an anagram
        return Arrays.equals(sArray, tArray);
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/valid-anagram/)