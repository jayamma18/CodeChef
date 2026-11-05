class Solution {
    public void rotate(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int lastElement = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;
    }
}
