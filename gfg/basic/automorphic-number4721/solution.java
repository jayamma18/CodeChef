class Solution {
    public String isAutomorphic(int n) {
        long square = (long) n * n;
        int temp = n;
        long multiplier = 1;

        // Find the base (10, 100, 1000...) based on the number of digits in n
        while (temp > 0) {
            multiplier *= 10;
            temp /= 10;
        }

        // If the remainder of the square divided by the multiplier equals n
        if (square % multiplier == n) {
            return "Automorphic";
        }

        return "Not Automorphic";
    }
}
