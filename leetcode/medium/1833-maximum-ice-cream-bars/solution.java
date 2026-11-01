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
