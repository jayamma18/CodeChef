import java.util.*;

class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                ans.add(Arrays.asList(i, n - i));
            }
        }

        return ans;
    }

    boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;

        return true;
    }
}