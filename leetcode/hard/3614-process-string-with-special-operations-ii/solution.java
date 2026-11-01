class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n];
        long curLen = 0;

        // Forward Pass: Track string lengths at each index
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (curLen > 0) curLen--;
            } else if (ch == '#') {
                curLen *= 2;
            } else if (ch == '%') {
                // Reversing doesn't change length
            } else {
                curLen++;
            }
            lengths[i] = curLen;
        }

        // Check if k is completely out of bounds
        if (k >= curLen || k < 0) {
            return '.';
        }

        // Backward Pass: Backtrack the target index k
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = (i == 0) ? 0 : lengths[i - 1];

            if (ch == '*') {
                // Skip back over deleted segment tracking
                continue;
            } else if (ch == '#') {
                // If k lies in the duplicated copy half, map it back to the original half
                if (k >= prevLen) {
                    k %= prevLen;
                }
            } else if (ch == '%') {
                // Mirror the index position for the reverse inversion operation
                k = prevLen - 1 - k;
            } else {
                // If ch is a letter and k matches its exact position, return it
                if (k == lengths[i] - 1) {
                    return ch;
                }
            }
        }

        return '.';
    }
}
