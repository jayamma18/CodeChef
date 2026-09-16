# Remove Sandwiched Vowels

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given string  **s** containing only lowercase English alphabets, eliminate the vowels from the string that occur between two consonants (sandwiched between two immediately adjacent consonants). Return the new string.

 **Examples:** 

```
Input : s = "bab"
Output : bb
Explanation: 'a' is a vowel occuring between two consonants i.e. b. Hence the updated string eliminates a.
```

```
Input : s = "ceghij"
Output : cghj
Explanation: 'e' and 'i' are sandwitched vowels.
```

**Constraints:
**1 ≤ s.size() ≤ 106
'a' ≤ s[i] ≤ 'z'

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:12:43.546Z  

```java
class Solution {
    public static String sandwichedVowel(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i > 0 && i < s.length() - 1 &&
                isVowel(ch) &&
                !isVowel(s.charAt(i - 1)) &&
                !isVowel(s.charAt(i + 1))) {
                continue;
            }

            result.append(ch);
        }

        return result.toString();
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u';
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sandwiched-vowels5158/1)