# Reverse Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the  **head** of a singly linked list. Reverse the linked list and return the head of the reversed list.

 **Examples:** 

```
Input:

Output: 4 -> 3 -> 2 -> 1
Explanation: After reversing the linked list

```

```
Input: 

Output: 8 -> 9 -> 10 -> 7 -> 2
Explanation: After reversing the linked list

```

```
Input: 

Output: 8
Explanation:

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T08:56:37.392Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1)