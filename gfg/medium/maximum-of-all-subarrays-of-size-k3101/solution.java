import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current sliding window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // Remove all elements smaller than the currently added element
            // from the back of the deque
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element's index at the back
            deque.offerLast(i);

            // The maximum element for the window is at the front of the deque
            // Only add to results once the first window of size k is fully formed
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }
}
