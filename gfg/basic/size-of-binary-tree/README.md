# Size of Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given the root of a binary tree, return the size of the tree. The size of a binary tree is the total number of nodes in the tree.

 **Examples:** 

```
Input:      

Output:  3
Explanation: There are 3 nodes in the given binary tree, so its size is 3.
```

```
Input:

Output: 6
Explanation: There are 6 nodes in the given binary tree, so its size is 6.
```

 **Constraints:** 
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:24:35.353Z  

```java
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
    // Function to return the size of the binary tree.
    public int getSize(Node root) {
        // Base case: if the tree is empty, its size is 0
        if (root == null) {
            return 0;
        }

        // Size of tree = 1 (current node) + size of left subtree + size of right subtree
        return 1 + getSize(root.left) + getSize(root.right);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/size-of-binary-tree/1)