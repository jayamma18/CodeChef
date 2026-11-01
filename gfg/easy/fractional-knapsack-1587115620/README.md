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
**Submitted:** 2026-11-01T12:50:30.822Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1)