# Longest Word in Dictionary

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of strings `words` representing an English Dictionary, return  *the longest word in*  `words`  *that can be built one character at a time by other words in*  `words`.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end of a previous word. 

 

 **Example 1:** 

```
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

```

 **Example 2:** 

```
Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

```

 

 **Constraints:** 

- 1 <= words.length <= 1000
- 1 <= words[i].length <= 30
- words[i] consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 41.5 MB  
**Submitted:** 2026-11-05T10:45:50.684Z  

```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> builtWords = new HashSet<>();
        String longest = "";
        
        for (String word : words) {
            if (word.length() == 1 || builtWords.contains(word.substring(0, word.length() - 1))) {
                builtWords.add(word);
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
        }
        
        return longest;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/longest-word-in-dictionary/)