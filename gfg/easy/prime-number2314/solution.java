class Solution {
    static boolean isPrime(int n) {
        // Base cases: Numbers less than or equal to 1 are not prime
        if (n <= 1) {
            return false;
        }

        // 2 and 3 are prime numbers
        if (n <= 3) {
            return true;
        }

        // Eliminate multiples of 2 and 3 quickly
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Check divisors up to square root of n, skipping multiples of 2 and 3
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
