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
