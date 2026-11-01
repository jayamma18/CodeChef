class Solution {
    // Cumulative mapping of days in each month for a non-leap year
    private final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Convert all dates into absolute day positions (1 to 365)
        int startAlice = convertToDayOfYear(arriveAlice);
        int endAlice = convertToDayOfYear(leaveAlice);
        int startBob = convertToDayOfYear(arriveBob);
        int endBob = convertToDayOfYear(leaveBob);

        // Find the boundary points of their mutual stay
        int latestArrival = Math.max(startAlice, startBob);
        int earliestDeparture = Math.min(endAlice, endBob);

        // Calculate overlap duration
        if (latestArrival <= earliestDeparture) {
            return earliestDeparture - latestArrival + 1;
        }
        
        return 0;
    }

    private int convertToDayOfYear(String date) {
        // Split "MM-DD" string format into integer parts
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int totalDays = 0;
        // Sum days of all preceding months
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        
        return totalDays + day;
    }
}
