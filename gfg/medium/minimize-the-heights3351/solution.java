import java.util.Arrays;

class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        // If there is only one tower, the difference between largest and smallest is 0
        if (n == 1) return 0;

        // Step 1: Sort the array to organize towers by ascending height
        Arrays.sort(arr);

        // Initial maximum possible difference without any specific split point modification
        int res = arr[n - 1] - arr[0];

        // Step 2: Iterate through possible partition split points
        for (int i = 0; i < n - 1; i++) {
            // Ensure modifying the height down does not create a illegal negative height
            if (arr[i + 1] - k < 0) {
                continue;
            }

            // Potential minimum height after split operations
            int minHeight = Math.min(arr[0] + k, arr[i + 1] - k);

            // Potential maximum height after split operations
            int maxHeight = Math.max(arr[n - 1] - k, arr[i] + k);

            // Update response to keep tracking of the absolute minimal range found
            res = Math.min(res, maxHeight - minHeight);
        }

        return res;
    }
}
