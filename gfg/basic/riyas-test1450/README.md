# Same Frequency in Two Halves

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a string  **s**, split it into two halves from the middle. If the length of s is odd, ignore the middle character before splitting.

 **Examples:** 

```
Input: s = "abcdbca"
Output: true
Explanation: The string has length 7 which is odd, hence we ignore the middle character 'd'. The frequency of 'a', 'b' and 'c' is same in both the halves.
```

```
Input: s = "abbaab"
Output: false
Explanation: The first half "abb" and the second half "aab" do not have the same character frequencies.
```

 **Constraints:** 
1 ≤ |s| ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T06:05:06.449Z  

```java
class Solution {
    public static boolean halvesMatch(String s) {
        int n = s.length();
        int mid = n / 2;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < mid; i++) {
            freq1[s.charAt(i) - 'a']++;
        }

        for (int i = n - mid; i < n; i++) {
            freq2[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/riyas-test1450/1)