# Valid Parenthesis String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` containing only three types of characters: `'('`, `')'` and `' *'`, return `true`* if *`s`* is  **valid** *.

The following rules define a  **valid**  string:

- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

 

 **Example 1:** 

```
Input: s = "()"
Output: true

```

 **Example 2:** 

```
Input: s = "(*)"
Output: true

```

 **Example 3:** 

```
Input: s = "(*))"
Output: true

```

 **Example 4:** 

```
Input: s = "("
Output: false

```

 

 **Constraints:** 

- 1 <= s.length <= 100
- s[i] is '(', ')' or '*'.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.1 MB (beats 99.04%)  
**Submitted:** 2026-11-01T11:16:18.320Z  

```java
class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open brackets remaining
        int maxOpen = 0; // Maximum possible open brackets remaining
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--; // If * acts as ')'
                maxOpen++; // If * acts as '('
            }
            
            // If maxOpen is negative, there are too many closing brackets ')' 
            // than can ever be balanced by '(' or '*'
            if (maxOpen < 0) {
                return false;
            }
            
            // minOpen cannot drop below 0 because we cannot carry over 
            // "negative" open brackets to the next characters
            if (minOpen < 0) {
                minOpen = 0;
            }
        }
        
        // The string is valid if we can successfully finish with 0 open brackets
        return minOpen == 0;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/valid-parenthesis-string/)