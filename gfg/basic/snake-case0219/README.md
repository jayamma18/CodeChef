# Snake Case

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a sentence  **s**  consisting of English alphabet characters and spaces, convert it into snake_case.

In snake case:

- All letters are converted to lowercase.
- Words are separated by a single underscore ('_') instead of spaces.
- No spaces should appear in the resulting string.

Return the snake_case representation of the given sentence.

 **Note:**  The input sentence does not begin with a whitespace character.

 **Examples:** 

```
Input: s = "Geeks ForGeeks"
Output: "geeks_forgeeks"
Explanation: All upper case characters are converted to lower case and the whitespace characters are replaced with underscore '_'.
```

```
Input: s = "Here comes the garden"
Output: "here_comes_the_garden"
Explanation: All upper case characters are converted to lower case and the whitespace characters are replaced with underscore '_'.
```

 **Constraints:** 
1 ≤ n ≤ 105, n is length of the sentence

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:08:28.422Z  

```java
class Solution {
    public static String snakeCase(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                result.append('_');
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/snake-case0219/1)