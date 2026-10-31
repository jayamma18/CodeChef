import java.util.Arrays;

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][] activities = new int[n][2];

        // Combine start and finish times into a single 2D array
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        // Sort activities based on their finish times in ascending order
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastFinishTime = -1; // Keeps track of the end time of the last chosen activity

        for (int i = 0; i < n; i++) {
            // Check if the current activity starts strictly after the last one finished
            if (activities[i][0] > lastFinishTime) {
                count++;
                lastFinishTime = activities[i][1]; // Update the finish time threshold
            }
        }

        return count;
    }
}
