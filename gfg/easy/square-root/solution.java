class Solution {
    int floorSqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int low = 1, high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the perfect square root
            if (mid == n / mid) {
                return mid;
            }

            // If mid*mid is less than n, it's a potential floor answer
            if (mid < n / mid) {
                ans = mid;
                low = mid + 1; // Try to find a larger value
            } else {
                high = mid - 1; // mid*mid is greater than n
            }
        }
        return ans;
    }
}
