# Remove Consonants

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**, remove all consonants and return the modified string containing only vowels.

If the string does not contain any vowels, return an empty string.

 **Examples:** 

```
Input: s = "abEkipo"
Output: "aEio"
Explanation: a, E, i, o are only vowels in the string.

```

```
Input: s = "rrty"
Output: ""
Explanation: There are no vowels.

```

 **Constraints** 
1 ≤ n ≤ 105, n is length of the string
The string should consist of only alphabets.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:19:08.863Z  

```java
class Solution {
    public String remConsonants(String s) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/c-program-to-remove-consonants-from-a-string1945/1)