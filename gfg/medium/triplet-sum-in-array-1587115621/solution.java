import java.util.Arrays;

class Solution {
    // Function to find if there exists a triplet in the array whose sum equals the given target.
    public boolean hasTripletSum(int[] arr, int target) {
        int n = arr.length;

        // Step 1: Sort the array to utilize the two-pointer technique
        Arrays.sort(arr);

        // Step 2: Fix the first element of the triplet one by one
        for (int i = 0; i < n - 2; i++) {

            // Initialize two pointers for the remaining part of the array
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    return true; // Triplet found
                } else if (currentSum < target) {
                    left++; // Need a larger sum, move left pointer right
                } else {
                    right--; // Need a smaller sum, move right pointer left
                }
            }
        }

        return false; // No triplet found
    }
}
