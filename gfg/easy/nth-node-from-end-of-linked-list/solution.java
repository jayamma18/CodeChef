class Solution {
    public int getKthFromLast(Node head, int k) {
        if (head == null || k <= 0) {
            return -1;
        }

        Node fast = head;
        Node slow = head;

        // Move the fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }

        // Move both pointers together until fast reaches the end (null)
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow now points to the kth node from the end
        return slow.data;
    }
}
