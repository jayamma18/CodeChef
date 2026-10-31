class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak element
            // Condition 1: Left neighbor is smaller (or mid is the first element)
            // Condition 2: Right neighbor is smaller (or mid is the last element)
            boolean leftSmaller = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightSmaller = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (leftSmaller && rightSmaller) {
                return mid;
            }

            // If the right neighbor is greater, a peak must exist on the right side
            if (mid < n - 1 && arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            } else {
                // Otherwise, a peak must exist on the left side
                high = mid - 1;
            }
        }

        return -1; // Fallback, though a peak element always exists
    }
}
