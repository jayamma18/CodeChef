class Solution {
    // Fenwick Tree (Binary Indexed Tree) implementation
    private static class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }

        void update(int i, int delta) {
            while (i <= size) {
                tree[i] += delta;
                i += i & (-i);
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & (-i);
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        // Prefix sums can range from -n to +n. 
        // We map this range to positive values using an offset.
        int offset = n + 1;
        int maxTreeIndex = 2 * n + 2;
        FenwickTree bit = new FenwickTree(maxTreeIndex);

        long validSubarraysCount = 0;
        int currentPrefixSum = 0;

        // Base case: Before elements are processed, prefixSum[0] = 0.
        // We insert the initial sum (0 + offset) into the tree.
        bit.update(0 + offset, 1);

        for (int num : nums) {
            // Transform target elements to +1, others to -1
            if (num == target) {
                currentPrefixSum += 1;
            } else {
                currentPrefixSum -= 1;
            }

            // Query how many previous prefix sums are strictly less than currentPrefixSum
            int queryIndex = currentPrefixSum + offset - 1;
            validSubarraysCount += bit.query(queryIndex);

            // Add the current prefix sum to the Fenwick Tree
            bit.update(currentPrefixSum + offset, 1);
        }

        return validSubarraysCount;
    }
}
