class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        // Step 1: Find the first decreasing element from the right (the pivot)
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // If a pivot is found (i.e., array is not entirely descending)
        if (i >= 0) {
            // Step 2: Find the next largest element from the right to swap with pivot
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // Step 3: Reverse the elements to the right of the pivot index
        reverse(arr, i + 1, n - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
