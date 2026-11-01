# Postorder Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given the  **root** of a Binary Tree, return its Postorder Traversal.

 **Note:** A postorder traversal first visits the left child (including its entire subtree), then visits the right child (including its entire subtree), and finally visits the node itself.

 **Examples:** 

```
Input: root = [19, 10, 8, 11, 13]

Output: [11, 13, 10, 8, 19]
Explanation: The postorder traversal of the given binary tree is [11, 13, 10, 8, 19].
```

```
Input: root = [11, 15, N, 7]
 
Output: [7, 15, 11]
Explanation: The postorder traversal of the given binary tree is [7, 15, 11].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:20:49.098Z  

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
    // Function to return a list containing the postorder traversal of the tree.
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    // Helper function for recursive postorder traversal
    private void traverse(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        
        // 1. Traverse the left subtree
        traverse(node.left, result);
        
        // 2. Traverse the right subtree
        traverse(node.right, result);
        
        // 3. Visit the root node
        result.add(node.data);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/postorder-traversal/1)