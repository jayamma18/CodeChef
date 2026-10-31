# Kth from End of Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the  **head**  of a linked list and an integer  **k**, return the kth node from the end of the linked list. If k is greater than the number of nodes in the list, return -1.

 **Examples :** 

```
Input: k = 2

Output: 8
Explanation: 

The 2nd node from end is 8.
```

```
Input: k = 3

Output: 40

The 3rd node from the end is 40.
```

```
Input: k = 5

Output: -1
Explanation: The given linked list is 10 -> 5 -> 100 -> 5. Since 'k' is more than the number of nodes, the output is -1.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:50:59.525Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1)