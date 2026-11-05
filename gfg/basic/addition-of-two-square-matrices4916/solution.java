class Solution {
    public void addMat(int[][] a, int[][] b) {
        int n = a.length;
        
        // Loop through each element and add matrix b into matrix a
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] += b[i][j];
            }
        }
    }
}
