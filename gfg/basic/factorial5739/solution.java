class Solution {
    // Note: If the GFG driver code uses 'int', change the return type to int.
    // If it uses 'long', keep it as long. Both work fine for n <= 12.
    public long factorial(int n) {
        long result = 1;

        // Compute factorial iteratively
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
