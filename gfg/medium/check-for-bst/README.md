# Check for BST

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary tree, check whether it is a Binary Search Tree (BST) or not. A binary tree is considered a BST if it satisfies the following properties:
- All nodes in the left subtree of a node have values less than the node's value.
- All nodes in the right subtree of a node have values greater than the node's value.
- Both the left and right subtrees are also Binary Search Trees.
Return true if the given binary tree is a BST; otherwise, return false.

 **Examples:** 

```
Input: root = [2, 1, 3, N, N, N, 5]

Output: true 
Explanation: The left subtree of every node contains smaller data and right subtree of every node contains greater data. Hence, the tree is a BST.

```

```
Input: root = [2, N, 7, N, 6, N, 9] 

Output: false 
Explanation: Since the node to the right of node with data 7 has lesser value 6, hence it is not a valid BST.
```

```
Input: root = [10, 5, 20, N, N, 9, 25]

Output: false
Explanation: The node with data 9 present in the right subtree has lesser key value than root node 10.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:48:44.511Z  

```java
class Solution {
    // Keeps track of the previously visited node during inorder traversal
    private Node prev = null;

    public boolean isBST(Node root) {
        prev = null; // Reset pointer for clean execution
        return checkInorder(root);
    }

    private boolean checkInorder(Node node) {
        if (node == null) {
            return true;
        }

        // 1. Check the left subtree
        if (!checkInorder(node.left)) {
            return false;
        }

        // 2. Check the current node: it must be strictly greater than the previous node
        if (prev != null && node.data <= prev.data) {
            return false;
        }
        prev = node; // Update the previous node to current

        // 3. Check the right subtree
        return checkInorder(node.right);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/check-for-bst/1)