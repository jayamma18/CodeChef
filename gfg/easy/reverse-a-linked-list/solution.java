class Solution {
    Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next; // Store the next node before breaking the link
            curr.next = prev; // Reverse the current node's pointer
            prev = curr;      // Move prev one step forward
            curr = next;      // Move curr one step forward
        }

        // prev will be pointing to the new head of the reversed list
        return prev;
    }
}
