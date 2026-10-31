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
