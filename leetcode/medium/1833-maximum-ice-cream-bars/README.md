# Maximum Ice Cream Bars

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

It is a sweltering summer day, and a boy wants to buy some ice cream bars.

At the store, there are `n` ice cream bars. You are given an array `costs` of length `n`, where `costs[i]` is the price of the `ith` ice cream bar in coins. The boy initially has `coins` coins to spend, and he wants to buy as many ice cream bars as possible. 

 **Note:**  The boy can buy the ice cream bars in any order.

Return  *the  **maximum**  number of ice cream bars the boy can buy with* `coins` *coins.* 

You must solve the problem by counting sort.

 

 **Example 1:** 

```
Input: costs = [1,3,2,4,1], coins = 7
Output: 4
Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.

```

 **Example 2:** 

```
Input: costs = [10,6,8,7,7,8], coins = 5
Output: 0
Explanation: The boy cannot afford any of the ice cream bars.

```

 **Example 3:** 

```
Input: costs = [1,6,3,1,2,5], coins = 20
Output: 6
Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.

```

 

 **Constraints:** 

- costs.length == n
- 1 <= n <= 105
- 1 <= costs[i] <= 105
- 1 <= coins <= 108

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 98.48%)  
**Memory:** 83.5 MB (beats 70.21%)  
**Submitted:** 2026-11-01T11:28:26.295Z  

```java
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Find the maximum cost to size our frequency array
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        // Create the frequency array for counting sort
        int[] freq = new int[maxCost + 1];
        for (int cost : costs) {
            freq[cost]++;
        }

        int iceCreamBarsBought = 0;

        // Iterate through all possible costs starting from the cheapest (1)
        for (int price = 1; price <= maxCost; price++) {
            if (freq[price] == 0) {
                continue;
            }

            // If we can't even afford a single bar at this price, we are done
            if (coins < price) {
                break;
            }

            // Calculate how many bars at this price we can afford
            int countToBuy = Math.min(freq[price], coins / price);

            // Update total bars bought and remaining coins
            iceCreamBarsBought += countToBuy;
            coins -= countToBuy * price;
        }

        return iceCreamBarsBought;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/maximum-ice-cream-bars/)