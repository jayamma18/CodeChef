import java.util.*;

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

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // TreeMap stores sorted horizontal distances as keys, and the first seen node value as the value
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Pair> queue = new LinkedList<>();

        // Root is at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // If this horizontal distance is seen for the first time, it's visible from the top
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Left child goes to hd - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Right child goes to hd + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Extract values from the sorted map into the result list
        for (int value : map.values()) {
            res.add(value);
        }

        return res;
    }
}
