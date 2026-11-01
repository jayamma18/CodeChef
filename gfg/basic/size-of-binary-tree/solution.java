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
