import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        // Keep track of the current maximum level we have recorded a node for
        int[] maxLevel = {0}; 

        // Start DFS traversal from level 1
        dfs(root, 1, maxLevel, result);
        return result;
    }

    private void dfs(Node node, int currentLevel, int[] maxLevel, ArrayList<Integer> result) {
        // Base case: if node is null, backtrack
        if (node == null) {
            return;
        }

        // If this is the first time we encounter this depth level, record the node data
        if (currentLevel > maxLevel[0]) {
            result.add(node.data);
            maxLevel[0] = currentLevel;
        }

        // Prioritize left child first to capture the leftmost node at each level
        dfs(node.left, currentLevel + 1, maxLevel, result);
        dfs(node.right, currentLevel + 1, maxLevel, result);
    }
}
