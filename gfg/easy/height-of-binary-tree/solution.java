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
