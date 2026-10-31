import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array to handle order and duplicates easily
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        // Step 2: Use two pointers to find pairs summing to 0
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                result.add(pair);

                left++;
                right--;

                // Step 3: Skip duplicate elements for left pointer
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                // Skip duplicate elements for right pointer
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (sum < 0) {
                left++; // Sum is too small, move left pointer to a larger value
            } else {
                right--; // Sum is too large, move right pointer to a smaller value
            }
        }

        return result;
    }
}
