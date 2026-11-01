# Maximum Building Height

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You want to build `n` new buildings in a city. The new buildings will be built in a line and are labeled from `1` to `n`.

However, there are city restrictions on the heights of the new buildings:

- The height of each building must be a non-negative integer.
- The height of the first building must be 0.
- The height difference between any two adjacent buildings cannot exceed 1.

Additionally, there are city restrictions on the maximum height of specific buildings. These restrictions are given as a 2D integer array `restrictions` where `restrictions[i] = [idi, maxHeighti]` indicates that building `idi` must have a height  **less than or equal to**  `maxHeighti`.

It is guaranteed that each building will appear  **at most once**  in `restrictions`, and building `1` will  **not**  be in `restrictions`.

Return  *the  **maximum possible height**  of the  **tallest**  building*.

 

 **Example 1:** 

```
Input: n = 5, restrictions = [[2,1],[4,1]]
Output: 2
Explanation: The green area in the image indicates the maximum allowed height for each building.
We can build the buildings with heights [0,1,2,1,2], and the tallest building has a height of 2.
```

 **Example 2:** 

```
Input: n = 6, restrictions = []
Output: 5
Explanation: The green area in the image indicates the maximum allowed height for each building.
We can build the buildings with heights [0,1,2,3,4,5], and the tallest building has a height of 5.

```

 **Example 3:** 

```
Input: n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]]
Output: 5
Explanation: The green area in the image indicates the maximum allowed height for each building.
We can build the buildings with heights [0,1,2,3,3,4,4,5,4,3], and the tallest building has a height of 5.

```

 

 **Constraints:** 

- 2 <= n <= 109
- 0 <= restrictions.length <= min(n - 1, 105)
- 2 <= idi <= n
- idi is unique.
- 0 <= maxHeighti <= 109

## Solution

**Language:** Java  
**Runtime:** 57 ms (beats 47.71%)  
**Memory:** 125.4 MB (beats 32.57%)  
**Submitted:** 2026-11-01T11:27:16.445Z  

```java
import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // Handle case with no restrictions
        if (restrictions == null || restrictions.length == 0) {
            return n - 1;
        }

        // Create a new list containing all restrictions plus the boundary at building 1
        int len = restrictions.length;
        int[][] allRestrictions = new int[len + 1][2];
        allRestrictions[0] = new int[]{1, 0}; // Building 1 must have height 0
        System.arraycopy(restrictions, 0, allRestrictions, 1, len);

        // Sort restrictions by building ID
        Arrays.sort(allRestrictions, (a, b) -> Integer.compare(a[0], b[0]));

        int m = allRestrictions.length;

        // Pass 1: Left to Right
        for (int i = 1; i < m; i++) {
            int dist = allRestrictions[i][0] - allRestrictions[i - 1][0];
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], allRestrictions[i - 1][1] + dist);
        }

        // Pass 2: Right to Left
        for (int i = m - 2; i >= 0; i--) {
            int dist = allRestrictions[i + 1][0] - allRestrictions[i][0];
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], allRestrictions[i + 1][1] + dist);
        }

        // Calculate the maximum absolute height possible
        int maxOverallHeight = 0;
        for (int i = 0; i < m - 1; i++) {
            int id1 = allRestrictions[i][0];
            int h1 = allRestrictions[i][1];
            int id2 = allRestrictions[i + 1][0];
            int h2 = allRestrictions[i + 1][1];

            // Formula to find the max peak height between two restricted points
            int maxPeak = (h1 + h2 + (id2 - id1)) / 2;
            maxOverallHeight = Math.max(maxOverallHeight, maxPeak);
        }

        // Check the space between the last restricted building and building n
        int lastId = allRestrictions[m - 1][0];
        int lastH = allRestrictions[m - 1][1];
        maxOverallHeight = Math.max(maxOverallHeight, lastH + (n - lastId));

        return maxOverallHeight;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/maximum-building-height/)