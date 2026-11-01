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
