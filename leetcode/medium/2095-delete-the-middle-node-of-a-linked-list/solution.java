/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Base case: If the list has only 1 node, deleting it leaves an empty list
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        // Fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Unlink the middle node (slow) by connecting prev directly to slow.next
        prev.next = slow.next;
        
        return head;
    }
}
