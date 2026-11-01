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
    private int totalMoves;

    // GeeksforGeeks driver code expects this exact method name (case-sensitive)
    public int distCandy(Node root) {
        totalMoves = 0;
        countExcess(root);
        return totalMoves;
    }

    // Helper function using bottom-up postorder traversal
    private int countExcess(Node node) {
        if (node == null) {
            return 0;
        }

        // Traverse left and right subtrees
        int leftExcess = countExcess(node.left);
        int rightExcess = countExcess(node.right);

        // The number of moves required is the absolute value of candy flow from children
        totalMoves += Math.abs(leftExcess) + Math.abs(rightExcess);

        // Return the net balance of candies this subtree sends to its parent
        // (Current candies + incoming candies from children) - 1 candy kept for itself
        return node.data - 1 + leftExcess + rightExcess;
    }
}
