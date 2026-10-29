import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            // Add the current element to the window sum
            currentSum += arr[end];

            // Shrink the window from the left while currentSum is greater than target
            // and start pointer has not passed the end pointer
            while (currentSum > target && start < end) {
                currentSum -= arr[start];
                start++;
            }

            // If a valid subarray matching the target is found
            if (currentSum == target) {
                // 1-based indexing requires adding 1 to the 0-based indices
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }

        // If no such subarray exists, return -1
        result.add(-1);
        return result;
    }
}
