import java.util.*;

class Solution {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Edge cases where endpoints contain a thief directly
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] distToThief = new int[n][n];
        for (int[] row : distToThief) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> bfsQueue = new LinkedList<>();

        // Phase 1: Initialize Multi-source BFS with all thief coordinates
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    bfsQueue.offer(new int[]{r, c});
                    distToThief[r][c] = 0;
                }
            }
        }

        // Calculate Manhattan distance to the closest thief for all grid elements
        while (!bfsQueue.isEmpty()) {
            int[] curr = bfsQueue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && distToThief[nr][nc] == -1) {
                    distToThief[nr][nc] = distToThief[r][c] + 1;
                    bfsQueue.offer(new int[]{nr, nc});
                }
            }
        }

        // Phase 2: Find path maximizing the minimum safeness factor using a Max-Heap Dijkstra
        // Heap structure: [safeness_factor_so_far, row, col] sorted descendingly by safeness factor
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        boolean[][] visited = new boolean[n][n];

        maxHeap.offer(new int[]{distToThief[0][0], 0, 0});
        visited[0][0] = true;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int maxSafeness = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Reached the destination
            if (r == n - 1 && c == n - 1) {
                return maxSafeness;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    // Safeness of a path is governed by its weakest bottleneck link
                    int nextSafeness = Math.min(maxSafeness, distToThief[nr][nc]);
                    maxHeap.offer(new int[]{nextSafeness, nr, nc});
                }
            }
        }

        return 0;
    }
}
