class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int[][] mat) {
        int n = mat.length;

        // Step 1: Find the celebrity candidate using two pointers
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (mat[left][right] == 1) {
                // left knows right -> left cannot be the celebrity
                left++;
            } else {
                // left does not know right -> right cannot be the celebrity
                right--;
            }
        }

        // Candidate found at index 'left'
        int candidate = left;

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // A celebrity must NOT know anyone (mat[candidate][i] should be 0)
                // Everyone else MUST know the celebrity (mat[i][candidate] should be 1)
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
