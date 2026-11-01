import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // Handle case with no restrictions
        if (restrictions == null || restrictions.length == 0) {
            return n - 1;
        }

        // Create a new list containing all restrictions plus the boundary at building 1
        int len = restrictions.length;
        int[][] allRestrictions = new int[len + 1][2];
        allRestrictions[0] = new int[]{1, 0}; // Building 1 must have height 0
        System.arraycopy(restrictions, 0, allRestrictions, 1, len);

        // Sort restrictions by building ID
        Arrays.sort(allRestrictions, (a, b) -> Integer.compare(a[0], b[0]));

        int m = allRestrictions.length;

        // Pass 1: Left to Right
        for (int i = 1; i < m; i++) {
            int dist = allRestrictions[i][0] - allRestrictions[i - 1][0];
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], allRestrictions[i - 1][1] + dist);
        }

        // Pass 2: Right to Left
        for (int i = m - 2; i >= 0; i--) {
            int dist = allRestrictions[i + 1][0] - allRestrictions[i][0];
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], allRestrictions[i + 1][1] + dist);
        }

        // Calculate the maximum absolute height possible
        int maxOverallHeight = 0;
        for (int i = 0; i < m - 1; i++) {
            int id1 = allRestrictions[i][0];
            int h1 = allRestrictions[i][1];
            int id2 = allRestrictions[i + 1][0];
            int h2 = allRestrictions[i + 1][1];

            // Formula to find the max peak height between two restricted points
            int maxPeak = (h1 + h2 + (id2 - id1)) / 2;
            maxOverallHeight = Math.max(maxOverallHeight, maxPeak);
        }

        // Check the space between the last restricted building and building n
        int lastId = allRestrictions[m - 1][0];
        int lastH = allRestrictions[m - 1][1];
        maxOverallHeight = Math.max(maxOverallHeight, lastH + (n - lastId));

        return maxOverallHeight;
    }
}
