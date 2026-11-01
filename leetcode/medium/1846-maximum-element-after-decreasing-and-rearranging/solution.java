import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Step 1: Sort the array to process values sequentially
        Arrays.sort(arr);
        
        // Step 2: Enforce the rule that the first element must be 1
        arr[0] = 1;
        
        // Step 3: Iterate through the array and cap adjacent differences to at most 1
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] + 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        
        // Step 4: The last element will hold the maximized value
        return arr[arr.length - 1];
    }
}
