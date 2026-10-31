# Left View of Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the  **root** of a binary tree. Return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.

 **Note:**  If the tree is empty, return an empty list.

 **Examples :** 

```
Input: root = [1, 2, 3, 4, 5, N, N] 
 
Output:[1, 2, 4]
Explanation: From the left side of the tree, only the nodes 1, 2, and 4 are visible.

```

```
Input: root = [1, 2, 3, N, N, 4, N, N, 5, N, N]

Output: [1, 2, 4, 5]
Explanation: From the left side of the tree, only the nodes 1, 2, 4, and 5 are visible.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T07:47:23.366Z  

```java
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        // Keep track of the current maximum level we have recorded a node for
        int[] maxLevel = {0}; 

        // Start DFS traversal from level 1
        dfs(root, 1, maxLevel, result);
        return result;
    }

    private void dfs(Node node, int currentLevel, int[] maxLevel, ArrayList<Integer> result) {
        // Base case: if node is null, backtrack
        if (node == null) {
            return;
        }

        // If this is the first time we encounter this depth level, record the node data
        if (currentLevel > maxLevel[0]) {
            result.add(node.data);
            maxLevel[0] = currentLevel;
        }

        // Prioritize left child first to capture the leftmost node at each level
        dfs(node.left, currentLevel + 1, maxLevel, result);
        dfs(node.right, currentLevel + 1, maxLevel, result);
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1)