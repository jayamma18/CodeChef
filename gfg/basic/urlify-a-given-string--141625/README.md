# URLify a given string

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**, replace all the spaces in the string with '%20'.

 **Examples:** 

```
Input: s = "i love programming"
Output: "i%20love%20programming"
Explanation: The 2 spaces are replaced by '%20'

```

```
Input: s = "Mr Benedict Cumberbatch"
Output: "Mr%20Benedict%20Cumberbatch"
Explanation: The 2 spaces are replaced by '%20'
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T05:43:34.073Z  

```java
class Solution {
    public static String URLify(String s) {
        return s.replace(" ", "%20");
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/urlify-a-given-string--141625/1)