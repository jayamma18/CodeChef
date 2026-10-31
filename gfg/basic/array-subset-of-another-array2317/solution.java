import java.util.HashMap;

class Solution {
    public boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies of each element in array a[]
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Verify if elements of array b[] exist with adequate frequency in a[]
        for (int num : b) {
            // If the element is missing or its available count is 0, b is not a subset
            if (!map.containsKey(num) || map.get(num) == 0) {
                return false;
            }
            // Decrement the frequency count for the matched element
            map.put(num, map.get(num) - 1);
        }

        return true;
    }
}
