class Solution {
    // GeeksforGeeks driver code expects this exact method name
    public int reverseExponentiation(int n) {
        // Step 1: Find the reverse of the number n
        int temp = n;
        int reverse = 0;
        while (temp > 0) {
            reverse = reverse * 10 + (temp % 10);
            temp /= 10;
        }

        // Step 2: Calculate n raised to the power of reverse
        // Since constraints are small (1 <= n <= 10), Math.pow is perfectly safe
        return (int) Math.pow(n, reverse);
    }
}
