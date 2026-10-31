# Tree Boundary Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a root of a Binary Tree, return its boundary traversal in the following order:

- Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.
- Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.
- Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

 **Note:**  The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

 **Examples:** 

```
Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

```

```
Input: root = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
```

 **Constraints:** 
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:59:20.690Z  

```java
import java.util.ArrayList;
import java.util.Stack;

class Solution {

    // Helper function to check if a node is a leaf node
    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    // Function to add the left boundary nodes (excluding leaves)
    private void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Function to add all the leaf nodes from left to right
    private void addLeaves(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    // Function to add the right boundary nodes in reverse order (excluding leaves)
    private void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.right;
        Stack<Integer> stack = new Stack<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                stack.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // Add components in reverse order from the stack
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 1. Add root if it's not a leaf
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        // 2. Add left boundary
        addLeftBoundary(root, res);

        // 3. Add all leaf nodes
        addLeaves(root, res);

        // 4. Add right boundary in reverse order
        addRightBoundary(root, res);

        return res;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1)