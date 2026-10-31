class Solution {
    public int leastAvg(int[] arr, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int minSum = sum;
        int minIndex = 0;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];

            if (sum < minSum) {
                minSum = sum;
                minIndex = i - k + 1;
            }
        }

        return minIndex + 1;
    }
}