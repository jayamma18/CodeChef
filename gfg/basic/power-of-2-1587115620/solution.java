class Solution {
    // Check if the given number is a power of two
    public boolean isPowerofTwo(long n) {
        // Zero and negative numbers cannot be a power of two
        if (n <= 0) {
            return false;
        }

        // Bitwise trick: n & (n - 1) clears the lowest set bit
        return (n & (n - 1)) == 0;
    }
}
