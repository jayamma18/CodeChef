class Solution {
    // Main function to return inversion count
    int inversionCount(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Function to handle divide and conquer splits
    private int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;

            // Count inversions in the left subarray
            count += mergeSortAndCount(arr, l, m);

            // Count inversions in the right subarray
            count += mergeSortAndCount(arr, m + 1, r);

            // Count split inversions during merge stage
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    // Function to merge two sorted halves and calculate split inversions
    private int mergeAndCount(int[] arr, int l, int m, int r) {
        // Create copies of sub-segments
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];

        for (int i = 0; i < left.length; i++) left[i] = arr[l + i];
        for (int i = 0; i < right.length; i++) right[i] = arr[m + 1 + i];

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                // Core Logic: If left[i] > right[j], then all remaining elements 
                // from left[i] to left[left.length - 1] form an inversion pair with right[j]
                swaps += (left.length - i);
            }
        }

        // Clean up remaining elements
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

        return swaps;
    }
}
