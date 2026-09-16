# Any Common Word in Two Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given two arrays of strings  **s[ ]**  and  **t[ ]**  of sizes  **n**  and  **m** , respectively, determine whether they share at least one common string. Return true if there exists a string that appears in both arrays; otherwise, return false.

 **Examples:** 

```
Input: s[] = ["cake", "pastry", "fish", "candy"], t[] = ["burger", "ham", "fish", "cake", "sauce"]
Output: true
Explanation: The word "fish" is present in both arrays.
```

```
Input: s[] = ["pizza", "chicken", "cake", "chilli", "candy"], t[] = ["choco", "coco"]
Output: false
Explanation: There is no common word in the two arrays.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-16T05:49:44.680Z  

```java
import java.util.*;

class Solution {
    public static boolean commonString(String[] s, String[] t) {
        HashSet<String> set = new HashSet<>();

        for (String x : s) {
            set.add(x);
        }

        for (String x : t) {
            if (set.contains(x)) {
                return true;
            }
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sort-the-fest0016/1)