class Solution {
    // Function to return the nth Fibonacci number
    public int nthFibonacci(int n) {
        // Base case: F(0) = 0
        if (n == 0) {
            return 0;
        }
        // Base case: F(1) = 1
        if (n == 1) {
            return 1;
        }

        // Track the previous two values
        int prev2 = 0; // F(n-2)
        int prev1 = 1; // F(n-1)
        int current = 0;

        // Compute sequentially up to n
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
