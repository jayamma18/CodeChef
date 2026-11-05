class Solution {
    int fibExpression(int n) {
        // Cassini's Identity: f(n-1)*f(n+1) - f(n)*f(n) = (-1)^n
        // If n is even, (-1)^n is 1. If n is odd, (-1)^n is -1.
        if (n % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
