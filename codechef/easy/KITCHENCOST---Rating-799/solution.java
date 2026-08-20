class Solution {
    public int compute(int n, int x, int[] a, int[] b) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= x) {
                ans += b[i];
            }
        }
        return ans;
    }
}
