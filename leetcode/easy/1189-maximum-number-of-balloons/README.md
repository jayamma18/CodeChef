# Maximum Number of Balloons

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `text`, you want to use the characters of `text` to form as many instances of the word  **"balloon"**  as possible.

You can use each character in `text`  **at most once**. Return the maximum number of instances that can be formed.

 

 **Example 1:** 

```
Input: text = "nlaebolko"
Output: 1

```

 **Example 2:** 

```
Input: text = "loonbalxballpoon"
Output: 2

```

 **Example 3:** 

```
Input: text = "leetcode"
Output: 0

```

 

 **Constraints:** 

- 1 <= text.length <= 104
- text consists of lower case English letters only.

 

 **Note:**  This question is the same as 2287: Rearrange Characters to Make Target String.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 63.81%)  
**Memory:** 42.9 MB (beats 87.03%)  
**Submitted:** 2026-11-01T11:30:10.786Z  

```java
class Solution {
    public int maxNumberOfBalloons(String text) {
        // Frequency array for all 26 lowercase English letters
        int[] counts = new int[26];
        
        // Count characters in the input string
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }
        
        // Individual maximum instances based on each required letter
        int bCount = counts['b' - 'a'];
        int aCount = counts['a' - 'a'];
        int lCount = counts['l' - 'a'] / 2; // Requires 2 per word
        int oCount = counts['o' - 'a'] / 2; // Requires 2 per word
        int nCount = counts['n' - 'a'];
        
        // The bottleneck character determines the final max count
        return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/maximum-number-of-balloons/)