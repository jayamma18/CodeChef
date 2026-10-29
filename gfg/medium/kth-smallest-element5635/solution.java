import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Create a max heap using collections reverse order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Loop through all elements in the input array
        for (int num : arr) {
            maxHeap.add(num);

            // If the size of the heap exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // The root of the max-heap is the kth smallest element seen so far
        return maxHeap.peek();
    }
}
