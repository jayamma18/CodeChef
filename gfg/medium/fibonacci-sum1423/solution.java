class Solution {
    static long fibSum(long n) {
        long mod = 1000000007;

        if (n == 0) return 0;
        if (n == 1) return 1;

        long prev = 0; // f0
        long curr = 1; // f1
        long sum = 1;  // f0 + f1

        for (int i = 2; i <= n; i++) {
            long next = (prev + curr) % mod;
            sum = (sum + next) % mod;
            prev = curr;
            curr = next;
        }

        return sum;
    }
}
