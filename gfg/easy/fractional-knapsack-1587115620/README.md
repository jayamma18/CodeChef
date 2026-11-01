# Fractional Knapsack

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two arrays,  **val[]** and  **wt[]** , representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
Return the maximum value as a double, rounded to 6 decimal places.

 **Examples :** 

```
Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
Output: 240.000000
Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240

```

```
Input: val[] = [500], wt[] = [30], capacity = 10
Output: 166.670000
Explanation: Since the item’s weight exceeds capacity, we take a fraction 10/30 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:45:20.813Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1)