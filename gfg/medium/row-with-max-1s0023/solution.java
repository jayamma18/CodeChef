class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        if (n == 0) return -1;
        int m = arr[0].length;

        int r = 0;
        int c = m - 1; // Start at top-right corner
        int maxRowIndex = -1;

        while (r < n && c >= 0) {
            // If the element is 1, move left to find more 1s
            if (arr[r][c] == 1) {
                maxRowIndex = r; // Update the row index with max 1s
                c--;
            } 
            // If the element is 0, move down to check the next row
            else {
                r++;
            }
        }

        return maxRowIndex;
    }
}
