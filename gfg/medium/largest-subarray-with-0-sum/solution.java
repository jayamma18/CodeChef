import java.util.HashMap;

class Solution {
    int maxLength(int arr[]) {
        // HashMap to store (prefix_sum, first_occurrence_index)
        HashMap<Integer, Integer> map = new HashMap<>();

        int max_len = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the sum from index 0 to i is 0
            if (sum == 0) {
                max_len = i + 1;
            }

            // If this prefix sum was already seen, a 0-sum subarray is found
            if (map.containsKey(sum)) {
                max_len = Math.max(max_len, i - map.get(sum));
            } else {
                // Store the first occurrence of this prefix sum
                map.put(sum, i);
            }
        }

        return max_len;
    }
}
