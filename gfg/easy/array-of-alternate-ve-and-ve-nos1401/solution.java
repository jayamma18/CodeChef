import java.util.*;

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int x : arr) {
            if (x >= 0)
                pos.add(x);
            else
                neg.add(x);
        }

        int i = 0, j = 0, k = 0;

        while (i < pos.size() && j < neg.size()) {
            arr.set(k++, pos.get(i++));
            arr.set(k++, neg.get(j++));
        }

        while (i < pos.size()) {
            arr.set(k++, pos.get(i++));
        }

        while (j < neg.size()) {
            arr.set(k++, neg.get(j++));
        }
    }
}