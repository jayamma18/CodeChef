# Zig-Zag Tree Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the  **root** of a binary tree. Find the zig-zag level order traversal of the binary tree.
 **Note:** In zig zag traversal we traverse the nodes from left to right for odd-numbered levels, and from right to left for even-numbered levels.

 **Examples:** 

```
Input: root = [1, 2, 3, 4, 5, 6, 7]
          
Output: [1, 3, 2, 4, 5, 6, 7]
Explanation:
Level 1 (left to right): [1]
Level 2 (right to left): [3, 2]
Level 3 (left to right): [4, 5, 6, 7]
Final result: [1, 3, 2, 4, 5, 6, 7]
```

```
Input: root = [7, 9, 7, 8, 8, 6, N, 10, 9]
 
Output: [7, 7, 9, 8, 8, 6, 9, 10] 
Explanation:
Level 1 (left to right): [7]
Level 2 (right to left): [7, 9]
Level 3 (left to right): [8, 8, 6]
Level 4 (right to left): [9, 10]
Final result: [7, 7, 9, 8, 8, 6, 9, 10]
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:34:03.166Z  

```java
import java.util.*;

/*
// Node class definition for reference:
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/

class Solution {
    // Function to store the zig-zag level order traversal of a binary tree.
    public ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Flag to track direction: true for left-to-right, false for right-to-left
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Temporary array/list to store the elements of the current level
            Integer[] currentLevel = new Integer[levelSize];

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();

                // Determine the insertion position based on the traversal direction flag
                int index = leftToRight ? i : (levelSize - 1 - i);
                currentLevel[index] = curr.data;

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            // Add the ordered level elements directly to the final result list
            for (int val : currentLevel) {
                result.add(val);
            }

            // Flip the direction flag for the next level
            leftToRight = !leftToRight;
        }

        return result;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1)