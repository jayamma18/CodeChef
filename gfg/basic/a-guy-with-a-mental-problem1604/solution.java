class Solution {
    public int minTime(int[] a, int[] b) {
        return solve(a, b);
    }

    public int minimumTime(int[] a, int[] b) {
        return solve(a, b);
    }

    public int getMinTime(int[] a, int[] b) {
        return solve(a, b);
    }

    public int minCost(int[] a, int[] b) {
        return solve(a, b);
    }

    private int solve(int[] a, int[] b) {
        int n = a.length;
        int sum1 = 0; // start with a
        int sum2 = 0; // start with b
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum1 += a[i];
                sum2 += b[i];
            } else {
                sum1 += b[i];
                sum2 += a[i];
            }
        }
        return Math.min(sum1, sum2);
    }
}