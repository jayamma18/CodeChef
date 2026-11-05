class Solution {
    public int sumOfGP(int n, int a, int r) {
        // If common ratio is 1, sum is just the first term added n times
        if (r == 1) return a * n;
        
        // Use long for math to prevent negative number errors (overflow)
        long totalSum = (long) a * ((long) Math.pow(r, n) - 1) / (r - 1);
        
        return (int) totalSum;
    }
}
