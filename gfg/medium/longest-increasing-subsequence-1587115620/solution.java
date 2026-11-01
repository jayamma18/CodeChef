import java.util.ArrayList;

class Solution {
    // Function to find length of longest strictly increasing subsequence.
    public int lis(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // tail[i] will store the smallest tail of all increasing subsequences of length i+1
        ArrayList<Integer> tail = new ArrayList<>();

        for (int num : arr) {
            // Find the position of num in tail using Binary Search
            int idx = binarySearch(tail, num);

            // If num is greater than all elements in tail, append it
            if (idx == tail.size()) {
                tail.add(num);
            } else {
                // Otherwise, replace the existing element to maintain a smaller tail candidate
                tail.set(idx, num);
            }
        }

        return tail.size();
    }

    // Standard Binary Search to find the first element >= target (Lower Bound)
    private int binarySearch(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == target) {
                return mid; // For strictly increasing, identical elements should replace themselves
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
