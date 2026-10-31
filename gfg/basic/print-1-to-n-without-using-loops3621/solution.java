class Solution {
    public void printTillN(int n) {
        // Base case: stop recursion when n becomes 0
        if (n == 0) {
            return;
        }

        // Recursive call to process smaller numbers first
        printTillN(n - 1);

        // Print the current number followed by a space
        System.out.print(n + " ");
    }
}
