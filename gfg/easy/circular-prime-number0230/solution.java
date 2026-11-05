import java.util.*;

class Solution {
    public ArrayList<Integer> isCircularPrime(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            int x = i, d = (int)Math.pow(10, (int)Math.log10(i));
            boolean ok = true;

            do {
                for (int j = 2; j * j <= x; j++)
                    if (x % j == 0) { ok = false; break; }
                if (!ok) break;
                x = x % 10 * d + x / 10;
            } while (x != i);

            if (ok) ans.add(i);
        }
        return ans;
    }
}