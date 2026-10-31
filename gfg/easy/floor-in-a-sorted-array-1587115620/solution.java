class Solution {
    static int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If current element is less than or equal to x, it is a potential floor
            if (arr[mid] <= x) {
                ans = mid;        // Record the index
                low = mid + 1;    // Move right to find a larger floor or the last occurrence
            } else {
                high = mid - 1;   // Move left if the current element exceeds x
            }
        }

        return ans;
    }
}
