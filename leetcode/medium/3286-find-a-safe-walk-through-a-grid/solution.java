import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // Track the minimum health lost to reach each cell
        int[][] minHealthLost = new int[m][n];
        for (int[] row : minHealthLost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Deque for 0-1 BFS
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        
        // Base initialization at (0,0)
        minHealthLost[0][0] = grid.get(0).get(0);
        deque.offerFirst(new int[]{0, 0});
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];
            
            // Early exit if we reached the end
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = grid.get(nr).get(nc);
                    int nextCost = minHealthLost[r][c] + weight;
                    
                    // If we found a path with fewer health points lost
                    if (nextCost < minHealthLost[nr][nc]) {
                        minHealthLost[nr][nc] = nextCost;
                        
                        // 0-1 BFS optimization
                        if (weight == 0) {
                            deque.offerFirst(new int[]{nr, nc}); // Processing 0-weight paths first
                        } else {
                            deque.offerLast(new int[]{nr, nc});  // 1-weight paths appended to back
                        }
                    }
                }
            }
        }
        
        // To survive, the final health must be >= 1
        int finalHealthLost = minHealthLost[m - 1][n - 1];
        return health - finalHealthLost >= 1;
    }
}
