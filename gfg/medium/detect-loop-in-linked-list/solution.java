/* Linked List Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    // Function to check if the linked list has a loop.
    public boolean detectLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Moves 1 step
            fast = fast.next.next;  // Moves 2 steps

            // If they meet at the same node, a loop exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast pointer reached the end, meaning no loop
        return false;
    }
}
