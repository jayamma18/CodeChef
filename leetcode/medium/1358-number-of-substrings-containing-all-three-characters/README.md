# Number of Substrings Containing All Three Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` consisting only of characters  *a*,  *b*  and  *c*.

Return the number of substrings containing  **at least**  one occurrence of all these characters  *a*,  *b*  and  *c*.

 

 **Example 1:** 

```
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

```

 **Example 2:** 

```
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

```

 **Example 3:** 

```
Input: s = "abc"
Output: 1

```

 

 **Constraints:** 

- 3 <= s.length <= 5 x 104
- s only consists of 'a', 'b' or 'c' characters.

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 77.56%)  
**Memory:** 45.9 MB (beats 82.85%)  
**Submitted:** 2026-11-01T11:39:33.558Z  

```java
import java.util.Arrays;

class Solution {
    public int numberOfSubstrings(String s) {
        // Array to keep track of the last seen index of 'a', 'b', and 'c'
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1); // Initialize positions with -1
        
        int totalSubstrings = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // Update the last seen position of the current character
            lastSeen[s.charAt(i) - 'a'] = i;
            
            // If all three characters have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the smallest index among the three last seen positions
                int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                
                // Every starting position from index 0 up to minIndex creates a valid substring
                totalSubstrings += minIndex + 1;
            }
        }
        
        return totalSubstrings;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/)