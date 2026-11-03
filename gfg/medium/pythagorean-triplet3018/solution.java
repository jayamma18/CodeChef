class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // Step 1: Find the maximum element in the array to size our frequency tracker
        int maxElem = 0;
        for (int num : arr) {
            if (num > maxElem) {
                maxElem = num;
            }
        }

        // Step 2: Record the frequency of each element
        int[] hash = new int[maxElem + 1];
        for (int num : arr) {
            hash[num]++;
        }

        // Step 3: Iterate through all possible pairs of elements up to maxElem
        for (int i = 1; i <= maxElem; i++) {
            // If the first number 'i' doesn't exist in the array, skip it
            if (hash[i] == 0) continue;

            for (int j = 1; j <= maxElem; j++) {
                // If the second number 'j' doesn't exist, skip it
                if (hash[j] == 0) continue;

                // Handle the special case where a and b are the same number (e.g., 3^2 + 3^2 = c^2)
                // We need at least two copies of this number in the array
                if (i == j && hash[i] < 2) continue;

                // Calculate the required c^2 value
                int cSq = (i * i) + (j * j);
                int c = (int) Math.sqrt(cSq);

                // Check if 'c' is a perfect square and actually exists in our hash array
                if (c * c == cSq && c <= maxElem && hash[c] > 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
