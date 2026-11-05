class Solution {
    public String isAutomorphic(int n) {
        long sq = (long) n * n;

        // Loop while there are digits left in n
        while (n > 0) {
            if (n % 10 != sq % 10) return "Not Automorphic";
            n /= 10;
            sq /= 10;
        }

        return "Automorphic";
    }
}
