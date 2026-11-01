import java.util.Arrays;

class Solution {
    // Function to check if a triplet with a sum equal to zero exists in the array.
    public boolean findTriplets(int[] arr) {
        int n = arr.length;

        // Step 1: Sort the array to implement the two-pointer technique
        Arrays.sort(arr);

        // Step 2: Fix the first element of the triplet one by one
        for (int i = 0; i < n - 2; i++) {

            // Initialize two pointers for the remaining part of the array
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == 0) {
                    return true; // Triplet found whose sum is 0
                } else if (currentSum < 0) {
                    left++; // Sum is too small, move left pointer right
                } else {
                    right--; // Sum is too large, move right pointer left
                }
            }
        }

        return false; // No such triplet exists
    }
}
