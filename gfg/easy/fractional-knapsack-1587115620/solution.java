import java.util.Arrays;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;

        // Create an index array to sort elements based on ratio without altering original inputs
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices in descending order based on value-to-weight ratio
        Arrays.sort(indices, (a, b) -> {
            double ratioA = (double) val[a] / wt[a];
            double ratioB = (double) val[b] / wt[b];
            return Double.compare(ratioB, ratioA); // Descending order
        });

        double totalValue = 0.0;
        int currentCapacity = capacity;

        for (int i = 0; i < n; i++) {
            if (currentCapacity == 0) {
                break;
            }

            int idx = indices[i];

            // If the full item fits, take it completely
            if (wt[idx] <= currentCapacity) {
                totalValue += val[idx];
                currentCapacity -= wt[idx];
            } 
            // Otherwise, take the maximum fraction possible and stop
            else {
                totalValue += ((double) val[idx] / wt[idx]) * currentCapacity;
                break;
            }
        }

        return totalValue;
    }
}
