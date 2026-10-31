class Solution {
    // Keeps track of the previously visited node during inorder traversal
    private Node prev = null;

    public boolean isBST(Node root) {
        prev = null; // Reset pointer for clean execution
        return checkInorder(root);
    }

    private boolean checkInorder(Node node) {
        if (node == null) {
            return true;
        }

        // 1. Check the left subtree
        if (!checkInorder(node.left)) {
            return false;
        }

        // 2. Check the current node: it must be strictly greater than the previous node
        if (prev != null && node.data <= prev.data) {
            return false;
        }
        prev = node; // Update the previous node to current

        // 3. Check the right subtree
        return checkInorder(node.right);
    }
}
