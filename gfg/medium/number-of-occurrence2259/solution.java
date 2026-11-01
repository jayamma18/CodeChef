class Solution {
    // Function to count the occurrences of target in a sorted array.
    int countFreq(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);

        // If the element doesn't exist in the array, count is 0
        if (first == -1) {
            return 0;
        }

        int last = findLastOccurrence(arr, target);

        return last - first + 1;
    }

    // Binary Search to find the first occurrence of target
    private int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int firstIdx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                firstIdx = mid;
                high = mid - 1; // Keep searching on the left side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstIdx;
    }

    // Binary Search to find the last occurrence of target
    private int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int lastIdx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                lastIdx = mid;
                low = mid + 1; // Keep searching on the right side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastIdx;
    }
}
