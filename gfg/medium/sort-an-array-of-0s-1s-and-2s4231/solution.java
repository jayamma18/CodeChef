class Solution {
    public void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // Traverse the array until mid meets high
        while (mid <= high) {
            if (arr[mid] == 0) {
                // If the element is 0, swap it to the lower segment
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // If the element is 1, it's already in the correct relative spot
                mid++;
            } else if (arr[mid] == 2) {
                // If the element is 2, swap it to the higher segment
                swap(arr, mid, high);
                high--;
                // Note: Do not increment mid here because the swapped element from high needs to be evaluated
            }
        }
    }

    // Helper method to swap elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
