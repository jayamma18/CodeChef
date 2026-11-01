# Height of Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the  **root** of a binary tree, find the maximum depth of the tree.

 **Note:** The maximum depth or height of the tree is the number of edges in the tree from the root to the deepest node.

 **Examples:** 

```
Input: root = [12, 8, 18, 5, 11]

Output: 2
Explanation: One of the longest path from the root(node 12) goes through node 8 to node 5, which has 2 edges.
```

```
Input: root = [1, 2, 3, 4, N, 10, 5, N, N, N, N, 6, 7]

Output: 3
Explanation: The longest path from the root(node 1) to a leaf node 6 with 3 edges.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:37:32.856Z  

```java
/* 
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    int height(Node node) {
        // Base case: An empty tree has -1 edges
        if (node == null) {
            return -1; 
        }

        // Base case: A single leaf node has 0 edges
        if (node.left == null && node.right == null) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // The height of the current node is 1 + maximum height of its subtrees
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1)