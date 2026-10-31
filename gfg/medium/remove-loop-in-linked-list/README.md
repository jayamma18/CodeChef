# Remove Cycle in Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the  **head** of a singly linked list. A cycle exists if the last node points back to a previous node, forming a loop. Remove the loop from the linked list if it exists.

Internally, the driver code uses a variable  **x**  (1-based indexing) to represent the position of the node to which the last node is connected.

The driver code will print "true" if the linked list is correctly modified, otherwise it will print "false".

 **Examples:** 

```
Input:

Output: true
Explanation: The linked list contains a loop that begins at node x = 2. After removing the loop, the driver code prints true.
```

```
Input:

Output: true
Explanation: The linked list does not contain a loop (x = 0).
```

```
Input: 

Output: true
Explanation: The linked list contains a loop that begins at node x = 1. After removing the loop, the driver code prints true.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:05:39.172Z  

```java
/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        // Step 1: Detect if a loop exists
        boolean loopExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        // If no loop is found, simply return
        if (!loopExists) {
            return;
        }

        // Step 2: Find the start of the loop
        slow = head;

        // Edge case: If the loop starts at the head node
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // Break the loop
            return;
        }

        // General case: Move both pointers at equal speed to find the junction
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the loop
        fast.next = null;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1)