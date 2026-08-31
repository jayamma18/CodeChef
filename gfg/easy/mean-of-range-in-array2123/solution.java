import java.util.*;

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] prefix = new long[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long sum = prefix[r] - (l > 0? prefix[l-1] : 0);
            int len = r - l + 1;
            ans.add((int)(sum / len));
        }
        return ans;
    }
}