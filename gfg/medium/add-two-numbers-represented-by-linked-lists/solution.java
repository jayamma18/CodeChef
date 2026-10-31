class Solution {
    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // Helper function to remove leading zeros from a linked list
    private Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    public Node addTwoLists(Node head1, Node head2) {
        // Step 1: Strip leading zeros from both input lists
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);

        // If both lists are empty after stripping zeros, the sum is 0
        if (head1 == null && head2 == null) {
            return new Node(0);
        }

        // Step 2: Reverse both lists to add from least significant digit
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        // Step 3: Add corresponding digits along with carry
        while (head1 != null || head2 != null || carry > 0) {
            int sum = carry;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        // Step 4: Reverse the result list back to restore the original order
        return reverseList(dummy.next);
    }
}
