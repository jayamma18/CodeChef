import java.util.ArrayList;

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
    // GeeksforGeeks driver code expects this exact method name (case-sensitive)
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    // Helper function for recursive preorder traversal
    private void traverse(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        // 1. Visit the root node
        result.add(node.data);

        // 2. Traverse the left subtree
        traverse(node.left, result);

        // 3. Traverse the right subtree
        traverse(node.right, result);
    }
}
