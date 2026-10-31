import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;

        // Step 2: Use two pointers to traverse both arrays simultaneously
        while (i < a.length && j < b.length) {
            // Skip duplicate elements in array 'a'
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicate elements in array 'b'
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                addUnique(result, a[i]);
                i++;
            } else if (b[j] < a[i]) {
                addUnique(result, b[j]);
                j++;
            } else {
                addUnique(result, a[i]);
                i++;
                j++;
            }
        }

        // Process remaining elements of array 'a'
        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                addUnique(result, a[i]);
            }
            i++;
        }

        // Process remaining elements of array 'b'
        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                addUnique(result, b[j]);
            }
            j++;
        }

        return result;
    }

    // Helper function to prevent duplicates from consecutive additions
    private static void addUnique(ArrayList<Integer> list, int val) {
        if (list.isEmpty() || list.get(list.size() - 1) != val) {
            list.add(val);
        }
    }
}
