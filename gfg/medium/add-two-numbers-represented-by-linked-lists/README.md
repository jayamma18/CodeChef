# Add Number Linked Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the head of two singly linked lists  **head1**  and  **head2**  representing two non-negative integers. You need to return the  **head**  of the linked list representing the  **sum**  of these two numbers.

 **Note:** There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

 **Examples:** 

```
Input: 
    
Output:  1 -> 1 -> 2 -> 2
Explanation: Given numbers are 123 and 999. There sum is 1122.
    

```

```
Input: 
    
Output: 7 -> 0 
Explanation: Given numbers are 63 and 7. There sum is 70.
    
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:48:38.739Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1)