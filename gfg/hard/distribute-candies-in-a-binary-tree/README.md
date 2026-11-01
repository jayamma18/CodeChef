# Distribute Candies

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given the  **root**  of a binary tree with  **n**  nodes, where each node contains a certain number of candies, and the total number of candies across all nodes is n. In one move, you can select any two adjacent nodes and transfer one candy from one node to the other. The transfer can occur between a parent and child in either direction.

Find the minimum number of moves required to ensure that every node in the tree has exactly one candy.

 **Note:**  The testcases are framed such that it is always possible to achieve a configuration in which every node has exactly one candy, after some moves.

 **Examples:** 

```
Input: root = [5, 0, 0, N, N, 0, 0]
  
Output: 6
Explanation:
Move 1 candy from root to left child
Move 1 candy from root to right child
Move 1 candy from right child to root->right->left node
Move 1 candy from root to right child
Move 1 candy from right child to root->right->right node
Move 1 candy from root to right child
so, total 6 moves required.
```

```
Input: root = [2, 0, 0, N, N, 3, 0]
  
Output: 4
Explanation:
Move 1 candy from root to left child
Move 1 candy from root->right->left node to root->right node
Move 1 candy from root->right node to root->right->right node
Move 1 candy from root->right->left node to root->right node
so, total 4 moves required.
```

**Constraints:
**1 ≤ n ≤ 3*103
0 ≤ Node->data ≤ n
The sum of all Node->data = n

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:27:57.441Z  

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
    private int totalMoves;

    // GeeksforGeeks driver code expects this exact method name (case-sensitive)
    public int distCandy(Node root) {
        totalMoves = 0;
        countExcess(root);
        return totalMoves;
    }

    // Helper function using bottom-up postorder traversal
    private int countExcess(Node node) {
        if (node == null) {
            return 0;
        }

        // Traverse left and right subtrees
        int leftExcess = countExcess(node.left);
        int rightExcess = countExcess(node.right);

        // The number of moves required is the absolute value of candy flow from children
        totalMoves += Math.abs(leftExcess) + Math.abs(rightExcess);

        // Return the net balance of candies this subtree sends to its parent
        // (Current candies + incoming candies from children) - 1 candy kept for itself
        return node.data - 1 + leftExcess + rightExcess;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1)