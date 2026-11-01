import java.util.Arrays;

class Solution {
    // Helper class to group item properties and compute ratios accurately
    static class Item implements Comparable<Item> {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }

        // Sort in descending order of value/weight ratio
        @Override
        public int compareTo(Item other) {
            return Double.compare(other.ratio, this.ratio);
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        Item[] items = new Item[n];

        // Pack values and weights into our custom Item structures
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // Sort items by their density ratio (Greedy Choice Property)
        Arrays.sort(items);

        double totalValue = 0.0;
        int currentCapacity = capacity;

        for (int i = 0; i < n; i++) {
            if (currentCapacity == 0) {
                break;
            }

            // If the whole item can fit, take it completely
            if (items[i].weight <= currentCapacity) {
                totalValue += items[i].value;
                currentCapacity -= items[i].weight;
            } 
            // Otherwise, take the maximum fraction possible
            else {
                totalValue += items[i].ratio * currentCapacity;
                currentCapacity = 0;
            }
        }

        return totalValue;
    }
}
