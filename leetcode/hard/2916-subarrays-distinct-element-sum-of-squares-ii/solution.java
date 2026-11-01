import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    
    // Segment Tree Nodes
    private long[] sum1; // stores sum of x
    private long[] sum2; // stores sum of x^2
    private int[] lazy;  // stores lazy values for addition

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum1 = new long[4 * n];
        sum2 = new long[4 * n];
        lazy = new int[4 * n];

        // Track the last seen index of each number (Constraint: nums[i] <= 10^5)
        int[] lastPos = new int[100005];
        Arrays.fill(lastPos, -1);

        long totalSum = 0;

        for (int j = 0; j < n; j++) {
            int prevIdx = lastPos[nums[j]];
            int startRange = prevIdx + 1;
            int endRange = j;

            // Increment the count of distinct elements by 1 for all subarrays starting in [startRange, endRange]
            update(1, 0, n - 1, startRange, endRange, 1);

            // Add the sum of squares of all subarrays ending at index j to the total answer
            totalSum = (totalSum + sum2[1]) % MOD;

            // Record current position
            lastPos[nums[j]] = j;
        }

        return (int) totalSum;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] == 0) return;
        
        int mid = (l + r) >> 1;
        int leftChild = node << 1;
        int rightChild = (node << 1) | 1;
        int val = lazy[node];

        apply(leftChild, l, mid, val);
        apply(rightChild, mid + 1, r, val);

        lazy[node] = 0;
    }

    private void apply(int node, int l, int r, int val) {
        long len = r - l + 1;
        // (x + val)^2 = x^2 + 2*val*x + val^2 * len
        sum2[node] = (sum2[node] + 2L * val * sum1[node] + (long) val * val % MOD * len) % MOD;
        sum1[node] = (sum1[node] + (long) val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) >> 1;
        if (ql <= mid) {
            update(node << 1, l, mid, ql, qr, val);
        }
        if (qr > mid) {
            update((node << 1) | 1, mid + 1, r, ql, qr, val);
        }
        sum1[node] = (sum1[node << 1] + sum1[(node << 1) | 1]) % MOD;
        sum2[node] = (sum2[node << 1] + sum2[(node << 1) | 1]) % MOD;
    }
}
