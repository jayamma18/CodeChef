class Solution {
    // Function to count number of ways to reach the nth stair.
    int countWays(int n) {
        // Base cases
        if (n <= 1) {
            return 1;
        }

        int prev2 = 1; // ways(0)
        int prev1 = 1; // ways(1)
        int current = 0;

        // Iteratively compute ways up to n
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
