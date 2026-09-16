# Replace Substring with Space

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

An encoded string  **s** consists of uppercase English letters. The string is formed by inserting the substring "LIE" at different positions in a secret message. Extract the original secret message by removing all occurrences of "LIE" from the encoded string.

 **Examples:** 

```
Input: s = "LIEILIEAMLIELIECOOL"
Output: "I AM COOL"
Explanation: After removing every occurrence of "LIE", the remaining message is "I AM COOL".
```

```
Input: s = "LIELIEALIEBCLIE"
Output: "A BC"
Explanation: Removing all occurrences of "LIE" leaves "A BC".
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T05:47:30.740Z  

```java
class Solution {
    public static String extractMessage(String s) {
        return s.replaceAll("(LIE)+", " ").trim();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/extraction-of-secret-message0616/1)