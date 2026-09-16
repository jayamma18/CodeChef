# Count Distinct Vowels in String

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s,**  count the total  **distinct** vowels in the string. The string s contains  **lowercase** letters only.

 **Examples:** 

```
Input: s = geeksforgeeks
Output: 2
Explanation: String "geeksforgeeks" has 2 distinct vowel "e" and "o".
```

```
Input: s = world
Output: 1
Explanation: It has only 1 distinct vowel "o".
```

 **Constraints:** 
1 ≤ |s| ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:00:45.563Z  

```java
import java.util.*;

class Solution {
    public static int countVowels(String s) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                set.add(ch);
            }
        }

        return set.size();
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-distinct-vowels-in-string/1)