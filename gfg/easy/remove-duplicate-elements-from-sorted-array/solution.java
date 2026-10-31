import java.util.ArrayList;

class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        // Handle edge case for empty array
        if (arr == null || arr.length == 0) {
            return result;
        }

        // The first element is always distinct, so add it directly
        result.add(arr[0]);

        // Loop through the rest of the array
        for (int i = 1; i < arr.length; i++) {
            // If the current element is different from the previous one, it's unique
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }

        return result;
    }
}
