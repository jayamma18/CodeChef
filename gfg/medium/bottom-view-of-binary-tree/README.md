# Bottom View of Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

 **Note:** If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.

 **Examples :** 

```
Input: root = [1, 2, 3, 4, 5, N, 6]
    
Output: [4, 2, 5, 3, 6]
Explanation: The Green nodes represent the bottom view of below binary tree.
    

```

```
Input: root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]
    
Output: [5, 10, 4, 28, 25]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:42:40.850Z  

```java
import java.util.*;

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
    // Helper class to store a node along with its horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // TreeMap stores <Horizontal Distance, Node Data> sorted by HD
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Queue for Level Order Traversal (BFS)
        Queue<Pair> queue = new LinkedList<>();

        // Start BFS with the root node at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node currNode = temp.node;
            int currHd = temp.hd;

            // Overwrite the value for this horizontal distance 
            // to ensure the latest/bottom-most node remains
            map.put(currHd, currNode.data);

            // Enqueue left child with HD - 1
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, currHd - 1));
            }

            // Enqueue right child with HD + 1
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, currHd + 1));
            }
        }

        // Add all elements from the sorted map to the final result list
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1)