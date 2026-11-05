class Solution {
    public int equalLength(int[] arr) {
        // The process of replacing a number with its difference 
        // mimics the Euclidean algorithm for finding the GCD.
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            
            // Optimization: If GCD reaches 1, it cannot go any lower
            if (result == 1) {
                return 1;
            }
        }
        
        return result;
    }
    
    // Helper function to calculate GCD using the optimal Euclidean method
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
