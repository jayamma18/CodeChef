class Solution {
    public static String findDay(int date, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date);

        String[] days = {
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY"
        };

        return days[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }
}