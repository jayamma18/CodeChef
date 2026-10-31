class Solution {
    int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Initialize tracking variables with the first element
        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int overallMax = arr[0];

        // Traverse the array from the second element
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            // If the current element is negative, swap maxSoFar and minSoFar
            if (current < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Update max and min product ending at the current position
            maxSoFar = Math.max(current, maxSoFar * current);
            minSoFar = Math.min(current, minSoFar * current);

            // Update the global maximum product found so far
            overallMax = Math.max(overallMax, maxSoFar);
        }

        return overallMax;
    }
}
