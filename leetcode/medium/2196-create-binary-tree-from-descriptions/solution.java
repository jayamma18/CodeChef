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
