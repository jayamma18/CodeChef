class Solution {
    public void segregateElements(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int k = 0;

        for (int x : arr) {
            if (x >= 0)
                temp[k++] = x;
        }

        for (int x : arr) {
            if (x < 0)
                temp[k++] = x;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}