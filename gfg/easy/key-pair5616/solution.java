import java.util.HashSet;

class Solution {
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            // If the complement is already in the set, we found our pair
            if (seen.contains(complement)) {
                return true;
            }

            // Add the current number to the set
            seen.add(num);
        }

        return false;
    }
}
