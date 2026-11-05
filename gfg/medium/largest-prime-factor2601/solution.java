class Solution {
    public long largestPrimeFactor(long n) {
        long ans = 1;

        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans = i;
                n /= i;
            }
        }

        return Math.max(ans, n);
    }
}