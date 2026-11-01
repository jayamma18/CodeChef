# Process String with Special Operations I

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a string `s` consisting of lowercase English letters and the special characters: `*`, `#`, and `%`.

Build a new string `result` by processing `s` according to the following rules from left to right:

- If the letter is a lowercase English letter append it to result.
- A '*' removes the last character from result, if it exists.
- A '#' duplicates the current result and appends it to itself.
- A '%' reverses the current result.

Return the final string `result` after processing all characters in `s`.

 

 **Example 1:** 

 **Input:**  s = "a#b%*"

 **Output:**  "ba"

 **Explanation:** 

`i`	`s[i]`	Operation	Current `result`
0	`'a'`	Append `'a'`	`"a"`
1	`'#'`	Duplicate `result`	`"aa"`
2	`'b'`	Append `'b'`	`"aab"`
3	`'%'`	Reverse `result`	`"baa"`
4	`'*'`	Remove the last character	`"ba"`

Thus, the final `result` is `"ba"`.

 **Example 2:** 

 **Input:**  s = "z*#"

 **Output:**  ""

 **Explanation:** 

`i`	`s[i]`	Operation	Current `result`
0	`'z'`	Append `'z'`	`"z"`
1	`'*'`	Remove the last character	`""`
2	`'#'`	Duplicate the string	`""`

Thus, the final `result` is `""`.

 

 **Constraints:** 

- 1 <= s.length <= 20
- s consists of only lowercase English letters and special characters *, #, and %.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 77.82%)  
**Memory:** 54.8 MB (beats 70.17%)  
**Submitted:** 2026-11-01T11:20:19.816Z  

```java
class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '*') {
                // Remove the last character if it exists
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                // Duplicate the current string and append it to itself
                result.append(result.toString());
            } else if (ch == '%') {
                // Reverse the current string
                result.reverse();
            } else {
                // Append lowercase English letter
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/process-string-with-special-operations-i/)