class Solution {
    public boolean isSorted(int[] arr) {
        // A single element or empty array is always sorted
        if (arr == null || arr.length <= 1) {
            return true;
        }

        // Check if any element is greater than the next one
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false; // Found a decreasing pair
            }
        }

        return true; // No violations found, array is sorted
    }
}
