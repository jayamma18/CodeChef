import java.util.*;

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
    // Helper class to store a node along with its horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // TreeMap stores <Horizontal Distance, Node Data> sorted by HD
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Queue for Level Order Traversal (BFS)
        Queue<Pair> queue = new LinkedList<>();

        // Start BFS with the root node at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node currNode = temp.node;
            int currHd = temp.hd;

            // Overwrite the value for this horizontal distance 
            // to ensure the latest/bottom-most node remains
            map.put(currHd, currNode.data);

            // Enqueue left child with HD - 1
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, currHd - 1));
            }

            // Enqueue right child with HD + 1
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, currHd + 1));
            }
        }

        // Add all elements from the sorted map to the final result list
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }
}
