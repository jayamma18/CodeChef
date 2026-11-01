# Remove Covered Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array `intervals` where `intervals[i] = [li, ri]` represent the interval `[li, ri)`, remove all intervals that are covered by another interval in the list.

The interval `[a, b)` is covered by the interval `[c, d)` if and only if `c <= a` and `b <= d`.

Return  *the number of remaining intervals*.

 

 **Example 1:** 

```
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

```

 **Example 2:** 

```
Input: intervals = [[1,4],[2,3]]
Output: 1

```

 

 **Constraints:** 

- 1 <= intervals.length <= 1000
- intervals[i].length == 2
- 0 <= li < ri <= 105
- All the given intervals are unique.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 91.07%)  
**Memory:** 46 MB (beats 88.70%)  
**Submitted:** 2026-11-01T11:46:55.219Z  

```java
import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 1. Sort by start point ascending. If starts match, sort by end point descending.
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int remainingCount = intervals.length;
        int maxEnd = 0;

        // 2. Iterate through intervals and find covered ones
        for (int[] interval : intervals) {
            int end = interval[1];
            
            // Since intervals are sorted by start point, if current end <= maxEnd,
            // this interval is completely covered by a previous one.
            if (end <= maxEnd) {
                remainingCount--;
            } else {
                // Otherwise, update the maximum reach
                maxEnd = end;
            }
        }

        return remainingCount;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/remove-covered-intervals/)