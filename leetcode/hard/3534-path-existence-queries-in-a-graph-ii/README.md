# Path Existence Queries in a Graph II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer `n` representing the number of nodes in a graph, labeled from 0 to `n - 1`.

You are also given an integer array `nums` of length `n` and an integer `maxDiff`.

An  **undirected** edge exists between nodes `i` and `j` if the  **absolute**  difference between `nums[i]` and `nums[j]` is  **at most**  `maxDiff` (i.e., `|nums[i] - nums[j]| <= maxDiff`).

You are also given a 2D integer array `queries`. For each `queries[i] = [ui, vi]`, find the  **minimum**  distance between nodes `ui` and `vi`. If no path exists between the two nodes, return -1 for that query.

Return an array `answer`, where `answer[i]` is the result of the `ith` query.

 **Note:**  The edges between the nodes are unweighted.

 

 **Example 1:** 

 **Input:**  n = 5, nums = [1,8,3,4,2], maxDiff = 3, queries = [[0,3],[2,4]]

 **Output:**  [1,1]

 **Explanation:** 

The resulting graph is:

Query	Shortest Path	Minimum Distance
[0, 3]	0 → 3	1
[2, 4]	2 → 4	1

Thus, the output is `[1, 1]`.

 **Example 2:** 

 **Input:**  n = 5, nums = [5,3,1,9,10], maxDiff = 2, queries = [[0,1],[0,2],[2,3],[4,3]]

 **Output:**  [1,2,-1,1]

 **Explanation:** 

The resulting graph is:

Query	Shortest Path	Minimum Distance
[0, 1]	0 → 1	1
[0, 2]	0 → 1 → 2	2
[2, 3]	None	-1
[4, 3]	3 → 4	1

Thus, the output is `[1, 2, -1, 1]`.

 **Example 3:** 

 **Input:**  n = 3, nums = [3,6,1], maxDiff = 1, queries = [[0,0],[0,1],[1,2]]

 **Output:**  [0,-1,-1]

 **Explanation:** 

There are no edges between any two nodes because:

- Nodes 0 and 1: |nums[0] - nums[1]| = |3 - 6| = 3 > 1
- Nodes 0 and 2: |nums[0] - nums[2]| = |3 - 1| = 2 > 1
- Nodes 1 and 2: |nums[1] - nums[2]| = |6 - 1| = 5 > 1

Thus, no node can reach any other node, and the output is `[0, -1, -1]`.

 

 **Constraints:** 

- 1 <= n == nums.length <= 105
- 0 <= nums[i] <= 105
- 0 <= maxDiff <= 105
- 1 <= queries.length <= 105
- queries[i] == [ui, vi]
- 0 <= ui, vi < n

## Solution

**Language:** Java  
**Runtime:** 81 ms (beats 87.20%)  
**Memory:** 272.3 MB (beats 92.80%)  
**Submitted:** 2026-11-01T11:54:36.165Z  

```java
import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Create an array of objects/pairs to keep track of the original index after sorting
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i], i);
        }

        // Sort based on their numerical values
        Arrays.sort(nodes, (a, b) -> Integer.compare(a.val, b.val));

        // Track what position each original index maps to in the sorted array
        int[] sortedPos = new int[n];
        for (int i = 0; i < n; i++) {
            sortedPos[nodes[i].originalIndex] = i;
        }

        // Precompute component tracking and maximum skip reach arrays
        int[] componentId = new int[n];
        int currentId = 0;
        componentId[0] = currentId;

        for (int i = 1; i < n; i++) {
            if (nodes[i].val - nodes[i - 1].val > maxDiff) {
                currentId++;
            }
            componentId[i] = currentId;
        }

        // To find the shortest path cleanly, we can build a greedy jump array (similar to the Jump Game II strategy)
        // jumpRight[i] stores the furthest index in the sorted array we can reach from index i in 1 step going up
        int[] jumpRight = new int[n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && nodes[r].val - nodes[i].val <= maxDiff) {
                r++;
            }
            jumpRight[i] = r - 1;
        }

        // Build a Doubling Table (Binary Lifting) to answer jump queries in O(log n) time
        int LOG = 18; // 2^17 = 131,072 > 10^5
        int[][] up = new int[LOG][n];
        for (int i = 0; i < n; i++) {
            up[0][i] = jumpRight[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int uOriginal = queries[i][0];
            int vOriginal = queries[i][1];

            if (uOriginal == vOriginal) {
                answer[i] = 0;
                continue;
            }

            int u = sortedPos[uOriginal];
            int v = sortedPos[vOriginal];

            // If they belong to different unreachable value clusters, no path exists
            if (componentId[u] != componentId[v]) {
                answer[i] = -1;
                continue;
            }

            // Ensure u is the smaller value position for standardized left-to-right lifting
            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            // Use binary lifting to count the exact number of jumps needed to reach or exceed index v
            int steps = 0;
            int curr = u;
            
            for (int j = LOG - 1; j >= 0; j--) {
                if (up[j][curr] < v) {
                    curr = up[j][curr];
                    steps += (1 << j);
                }
            }
            
            // One final step to jump onto or past v
            answer[i] = steps + 1;
        }

        return answer;
    }

    private static class Node {
        int val;
        int originalIndex;

        Node(int val, int originalIndex) {
            this.val = val;
            this.originalIndex = originalIndex;
        }
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/)