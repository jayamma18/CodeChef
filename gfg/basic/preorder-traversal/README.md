# Preorder Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given the root of a binary tree, return its preorder traversal.  A preorder traversal first visits the node, then visits the left child (including its entire subtree), and finally visits the right child (including its entire subtree).

 **Examples:** 

```
Input: root = [1, 4, N, 4, 2]
   
Output: [1, 4, 4, 2]
Explanation: The preorder traversal of the given binary tree is [1, 4, 4, 2]
```

```
Input: root = [6, 3, 2, N, 1, 2, N]
    
Output: [6, 3, 1, 2, 2] 
Explanation: The preorder traversal of the given binary tree is [6, 3, 1, 2, 2] 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:06:47.010Z  

```java
import java.util.ArrayList;

/*
// Node class definition for reference:
class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    // GeeksforGeeks driver code expects this exact method name (case-sensitive)
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    // Helper function for recursive preorder traversal
    private void traverse(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        // 1. Visit the root node
        result.add(node.data);

        // 2. Traverse the left subtree
        traverse(node.left, result);

        // 3. Traverse the right subtree
        traverse(node.right, result);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/preorder-traversal/1)