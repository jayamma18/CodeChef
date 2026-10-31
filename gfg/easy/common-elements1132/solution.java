import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length && k < c.length) {
            // Found a common element in all three arrays
            if (a[i] == b[j] && b[j] == c[k]) {
                // Ensure no duplicate element is added to the result
                if (res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
                j++;
                k++;
            } 
            // Move the pointer that points to the smallest element
            else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }

        return res;
    }
}
