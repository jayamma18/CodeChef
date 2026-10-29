import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Get the original value (using absolute value since it might have been negated)
            int val = Math.abs(arr[i]);

            // Map the value to a 0-based index
            int index = val - 1;

            // If the element at this index is already negative, we've seen this value before
            if (arr[index] < 0) {
                result.add(val);
            } else {
                // Otherwise, mark the element at this index as visited by negating it
                arr[index] = -arr[index];
            }
        }

        return result;
    }
}
