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
