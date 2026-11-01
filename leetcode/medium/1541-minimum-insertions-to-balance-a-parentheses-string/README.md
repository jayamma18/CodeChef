# Minimum Insertions to Balance a Parentheses String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a parentheses string `s` containing only the characters `'('` and `')'`. A parentheses string is  **balanced**  if it can be formed using the following rules:

- The empty string is balanced.
- If A is balanced, then '(' + A + '))' is balanced.
- If A and B are balanced, then their concatenation is balanced.

In other words, every left parenthesis `'('` must have a corresponding pair of two consecutive right parentheses `'))'` that comes after it, and every right parenthesis must belong to exactly one such matching pair.

For example, `"())"`, `"())(())))"` and `"(())())))"` are balanced, while `")()"`, `"()))"` and `"(()))"` are not balanced.

You can insert the characters `'('` and `')'` at any position of the string to balance it if needed.

Return the  **minimum**  number of insertions needed to make `s` balanced.

 

 **Example 1:** 

 **Input:**  s = "(()))"

 **Output:**  1

 **Explanation:** 

The second `'('` is matched with two consecutive `')'`, but the first `'('` has only one matching `')'`. We need to insert one more `')'` at the end to make the string `"(())))"`, which is balanced.

 **Example 2:** 

 **Input:**  s = "())"

 **Output:**  0

 **Explanation:** 

The string is already balanced because its `'('` is followed by two consecutive `')'`, and both right parentheses belong to that matching pair.

 **Example 3:** 

 **Input:**  s = "))())("

 **Output:**  3

 **Explanation:** 

Insert `'('` at the beginning to match the first `'))'`, and insert `'))'` at the end to match the last `'('`. Three insertions are needed in total.

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of '(' and ')' only.

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 55.28%)  
**Memory:** 47.2 MB (beats 87.01%)  
**Submitted:** 2026-11-01T11:22:30.121Z  

```java
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int neededRight = 0; // Number of closing parentheses required
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // If we need an odd number of right parentheses, it means 
                // we have a single unmatched ')'. We must insert 1 ')' to complete it.
                if (neededRight % 2 != 0) {
                    insertions++;
                    neededRight--; // Now it's balanced up to this point
                }
                neededRight += 2; // Each '(' needs two ')'
            } else { // c == ')'
                neededRight--;
                
                // If neededRight drops below 0, it means we got an unexpected ')'
                if (neededRight < 0) {
                    insertions++;    // Insert 1 '(' to match the incoming pair
                    neededRight += 2; // A '(' gives 2 needed, and we just consumed 1, so add 2
                }
            }
        }
        
        // Any remaining needed right parentheses must be inserted at the end
        return insertions + neededRight;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)