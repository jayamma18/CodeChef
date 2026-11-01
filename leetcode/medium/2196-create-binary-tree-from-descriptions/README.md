# Create Binary Tree From Descriptions

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a 2D integer array `descriptions` where `descriptions[i] = [parenti, childi, isLefti]` indicates that `parenti` is the  **parent**  of `childi` in a  **binary**  tree of  **unique**  values. Furthermore,

- If isLefti == 1, then childi is the left child of parenti.
- If isLefti == 0, then childi is the right child of parenti.

Construct the binary tree described by `descriptions` and return  *its  **root***.

The test cases will be generated such that the binary tree is  **valid**.

 

 **Example 1:** 

```
Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

```

 **Example 2:** 

```
Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.

```

 

 **Constraints:** 

- 1 <= descriptions.length <= 104
- descriptions[i].length == 3
- 1 <= parenti, childi <= 105
- 0 <= isLefti <= 1
- The binary tree described by descriptions is valid.

## Solution

**Language:** Java  
**Runtime:** 64 ms (beats 79.93%)  
**Memory:** 79.2 MB (beats 88.88%)  
**Submitted:** 2026-11-01T11:07:18.213Z  

```java
import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            boolean isLeft = d[2] == 1;
            
            // Track child node to identify the root later
            children.add(childVal);
            
            // Get or create parent node instance
            TreeNode parentNode = map.computeIfAbsent(parentVal, TreeNode::new);
            
            // Get or create child node instance
            TreeNode childNode = map.computeIfAbsent(childVal, TreeNode::new);
            
            // Establish the tree pointer connection
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }
        
        // Find the root (the element in descriptions that is never a child)
        for (int[] d : descriptions) {
            if (!children.contains(d[0])) {
                return map.get(d[0]);
            }
        }
        
        return null;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/create-binary-tree-from-descriptions/)