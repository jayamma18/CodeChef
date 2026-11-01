class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Find the index of 0
        int idx0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
                break;
            }
        }

        // Check if it's a valid forward cyclic shift
        boolean isForward = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] + 1) % n) {
                isForward = false;
                break;
            }
        }

        if (isForward) {
            return getForwardCost(idx0, n);
        }

        // Check if it's a valid backward cyclic shift
        boolean isBackward = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) {
                isBackward = false;
                break;
            }
        }

        if (isBackward) {
            // Option 1: Left shifts until it's [n-1, ..., 0], then Reverse once
            int opt1 = ((idx0 + 1) % n) + 1;
            
            // Option 2: Reverse first, then solve as a forward cyclic shift
            int newIdx0 = n - 1 - idx0;
            int opt2 = 1 + getForwardCost(newIdx0, n);
            
            return Math.min(opt1, opt2);
        }

        // Impossible to sort via rotation and global reversal
        return -1;
    }

    private int getForwardCost(int idx0, int n) {
        if (idx0 == 0) return 0;
        return Math.min(idx0, n - idx0 + 2);
    }
}
