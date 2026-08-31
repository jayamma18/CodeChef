class Solution {
    public int[] sumArray(int[] arr) {
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = total - arr[i];
        }
        return arr;
    }
}