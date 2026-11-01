import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        
        // Direction vectors for moving up, down, left, and right
        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};
        
        // Traverse the entire grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we encounter an unvisited land cell (> 0)
                if (grid[i][j] > 0) {
                    long islandTotalValue = 0;
                    
                    // Queue for BFS traversal
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    
                    // Accumulate current cell value and sink it immediately to mark as visited
                    islandTotalValue += grid[i][j];
                    grid[i][j] = 0; 
                    
                    while (!queue.isEmpty()) {
                        int[] currentCell = queue.poll();
                        int currRow = currentCell[0];
                        int currCol = currentCell[1];
                        
                        // Check all 4-directional neighbors
                        for (int d = 0; d < 4; d++) {
                            int nextRow = currRow + rowOffsets[d];
                            int nextCol = currCol + colOffsets[d];
                            
                            // Validate grid boundaries and look for land properties
                            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] > 0) {
                                islandTotalValue += grid[nextRow][nextCol];
                                grid[nextRow][nextCol] = 0; // Mark cell as visited by sinking it
                                queue.offer(new int[]{nextRow, nextCol});
                            }
                        }
                    }
                    
                    // If the total accumulated island value matches the divisibility rule
                    if (islandTotalValue % k == 0) {
                        islandCount++;
                    }
                }
            }
        }
        
        return islandCount;
    }
}
