class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;

        // Always ensure binary search runs on the smaller array
        if (n > m) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;

            // Elements around the partition in array a
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : a[mid1];

            // Elements around the partition in array b
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : b[mid2];

            // Check if valid partition
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                // Too many elements from a, shift left
                high = mid1 - 1;
            } else {
                // Too few elements from a, shift right
                low = mid1 + 1;
            }
        }

        return 0;
    }
}
