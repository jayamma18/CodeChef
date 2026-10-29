class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        // If the array has only one element, 0 jumps are needed
        if (n <= 1) return 0;

        // If the first element is 0, we can never move anywhere
        if (arr[0] == 0) return -1;

        // Stores the maximal reachable index from any point visited so far
        int maxReach = arr[0];

        // Stores the number of steps we can still take within the current jump range
        int steps = arr[0];

        // Tracks the minimum number of jumps needed
        int jumps = 1;

        // Traverse the array
        for (int i = 1; i < n; i++) {
            // If we have safely reached the last element, return the total jumps
            if (i == n - 1) return jumps;

            // Greedily update the maximum index we can reach from the current position
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use up one step to move forward to the current position
            steps--;

            // If no more steps are left within the current jump range
            if (steps == 0) {
                // We must take another jump to extend our range
                jumps++;

                // If the current index is equal to or greater than maxReach, we are stuck
                if (i >= maxReach) return -1;

                // Reset steps for our new jump range
                steps = maxReach - i;
            }
        }

        return -1;
    }
}
