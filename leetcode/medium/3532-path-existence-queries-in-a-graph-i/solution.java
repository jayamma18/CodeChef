class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Array to store the component ID for each node
        int[] componentId = new int[n];
        int currentId = 0;
        componentId[0] = currentId;

        // Group elements into contiguous connected components
        for (int i = 1; i < n; i++) {
            // Since nums is sorted, checking adjacent values is sufficient
            if (nums[i] - nums[i - 1] > maxDiff) {
                currentId++; // Disconnected gap found, increment component group ID
            }
            componentId[i] = currentId;
        }

        // Process each query in O(1) time
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            // Connected if and only if both nodes share the same group ID
            answer[i] = (componentId[u] == componentId[v]);
        }

        return answer;
    }
}
