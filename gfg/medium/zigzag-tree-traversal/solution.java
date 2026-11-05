import java.util.*;

class Solution {
    public ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer[] currentLevel = new Integer[levelSize];

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                int index = leftToRight ? i : (levelSize - 1 - i);
                currentLevel[index] = curr.data;

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            for (int val : currentLevel) {
                result.add(val);
            }
            leftToRight = !leftToRight;
        }

        return result;
    }
}
