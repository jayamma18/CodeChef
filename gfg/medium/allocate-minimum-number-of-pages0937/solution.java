class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;

        // If books are fewer than students, allocation is impossible
        if (n < k) {
            return -1;
        }

        long low = 0;
        long high = 0; // Changed to long to prevent overflow

        // Establish the search boundaries
        for (int pages : arr) {
            low = Math.max(low, pages); 
            high += pages;              
        }

        long result = -1; // Changed to long to match search variables

        // Perform binary search within the bounds
        while (low <= high) {
            long mid = low + (high - low) / 2; // Changed to long

            if (isPossible(arr, k, mid)) {
                result = mid;     
                high = mid - 1;   
            } else {
                low = mid + 1;    
            }
        }

        return (int) result; // Cast back to int for the return type
    }

    // Helper function adjusted to take 'long' for maxPages
    private boolean isPossible(int[] arr, int k, long maxPages) {
        int studentsRequired = 1;
        long currentPagesSum = 0; // Changed to long to prevent overflow during summation

        for (int pages : arr) {
            if (currentPagesSum + pages > maxPages) {
                studentsRequired++;
                currentPagesSum = pages;

                if (studentsRequired > k) {
                    return false;
                }
            } else {
                currentPagesSum += pages;
            }
        }

        return true;
    }
}
