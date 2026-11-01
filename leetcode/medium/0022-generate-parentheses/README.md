# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` pairs of parentheses, write a function to  *generate all combinations of well-formed parentheses*.

 

 **Example 1:** 

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

```

 **Example 2:** 

```
Input: n = 1
Output: ["()"]

```

 

 **Constraints:** 

- 1 <= n <= 8

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 85.20%)  
**Memory:** 44 MB (beats 92.75%)  
**Submitted:** 2026-11-01T11:14:34.910Z  

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: If the string has reached the maximum required length, add it to our results
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        
        // Rule 1: We can always add an opening parenthesis if we haven't reached the limit 'n'
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Undo/Backtrack step
        }
        
        // Rule 2: We can only add a closing parenthesis if there are more open ones than closed ones
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Undo/Backtrack step
        }
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/generate-parentheses/)