# Minimum Add to Make Parentheses Valid

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A parentheses string is valid if and only if:

- It is the empty string,
- It can be written as AB (A concatenated with B), where A and B are valid strings, or
- It can be written as (A), where A is a valid string.

You are given a parentheses string `s`. In one move, you can insert a parenthesis at any position of the string.

- For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".

Return  *the minimum number of moves required to make* `s` *valid*.

 

 **Example 1:** 

```
Input: s = "())"
Output: 1

```

 **Example 2:** 

```
Input: s = "((("
Output: 3

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s[i] is either '(' or ')'.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 47.60%)  
**Memory:** 42.3 MB (beats 97.11%)  
**Submitted:** 2026-11-01T11:18:24.209Z  

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int closeNeeded = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                openNeeded++;
            } else { // c == ')'
                if (openNeeded > 0) {
                    openNeeded--; // Matched a valid pair
                } else {
                    closeNeeded++; // Unmatched closing parenthesis
                }
            }
        }
        
        return openNeeded + closeNeeded;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/)