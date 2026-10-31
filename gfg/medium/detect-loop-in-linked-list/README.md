# Detect Loop in Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a singly linked list, find if the given linked list contains a **loop or not**. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

 **Note:** Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null. Note that pos is not passed as a parameter.

 **Examples:** 

```
Input: pos = 2,
   
Output: true
Explanation: There exists a loop as last node is connected back to the second node.

```

```
Input: pos = 0,
   
Output: false
Explanation: There exists no loop in given linked list.

```

```
Input: pos = 1,
   
Output: true
Explanation: There exists a loop as last node is connected back to the first node.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:11:32.856Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1)