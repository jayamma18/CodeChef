class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProd = Integer.MIN_VALUE;
        int leftToRight = 1;
        int rightToLeft = 1;

        for (int i = 0; i < n; i++) {
            leftToRight *= arr[i];
            rightToLeft *= arr[n - 1 - i];

            // Record the maximum product found so far
            maxProd = Math.max(maxProd, Math.max(leftToRight, rightToLeft));

            // Reset the running product if a zero is encountered
            if (leftToRight == 0) {
                leftToRight = 1;
            }
            if (rightToLeft == 0) {
                rightToLeft = 1;
            }
        }

        return maxProd;
    }
}
