import java.util.*;

class Solution {
    public ArrayList<Integer> findEvenOccurrences(int[] arr) {
        LinkedHashMap<Integer, Integer> freq = new LinkedHashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                result.add(entry.getKey());
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }
}