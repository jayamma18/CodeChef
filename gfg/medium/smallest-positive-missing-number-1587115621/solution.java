class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Use Cycle Sort to put elements in their correct index positions
        for (int i = 0; i < n; i++) {
            // Keep swapping while the current element is in range [1, n]
            // and is not already at its correct position (arr[i] - 1)
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                // Swap arr[i] with the element at its target index
                int targetIdx = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[targetIdx];
                arr[targetIdx] = temp;
            }
        }

        // Step 2: Traverse the rearranged array to find the first mismatch
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // The expected positive number is missing
            }
        }

        // Step 3: If all elements 1 to n are present, the missing number is n + 1
        return n + 1;
    }
}
