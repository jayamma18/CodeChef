class Solution {
    int unvisitedLeaves(int arr[], int k) {
        boolean[] visited = new boolean[k + 1];
        for (int s : arr) {
            for (int j = s; j <= k; j += s) {
                visited[j] = true;
            }
        }
        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (!visited[i]) count++;
        }
        return count;
    }
}