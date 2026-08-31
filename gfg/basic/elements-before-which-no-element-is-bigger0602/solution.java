class Solution {
    public int countElements(int[] arr) {
        int count = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > maxSoFar) {
                count++;
                maxSoFar = x;
            }
        }
        return count;
    }
}