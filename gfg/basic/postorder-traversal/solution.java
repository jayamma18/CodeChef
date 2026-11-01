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
    // Function to return a list containing the postorder traversal of the tree.
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    // Helper function for recursive postorder traversal
    private void traverse(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        
        // 1. Traverse the left subtree
        traverse(node.left, result);
        
        // 2. Traverse the right subtree
        traverse(node.right, result);
        
        // 3. Visit the root node
        result.add(node.data);
    }
}
