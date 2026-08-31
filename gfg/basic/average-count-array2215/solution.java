import java.util.*;

class Solution {
    public int[] countArray(int[] arr, int x) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int avg = (arr[i] + x) / 2;
            res[i] = freq.getOrDefault(avg, 0);
        }
        return res;
    }
}