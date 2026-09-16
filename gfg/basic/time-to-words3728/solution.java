class Solution {
    public static String timeToWords(int h, int m) {
        String[] num = {
            "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "twenty one", "twenty two", "twenty three",
            "twenty four", "twenty five", "twenty six",
            "twenty seven", "twenty eight", "twenty nine"
        };

        if (m == 0) {
            return num[h] + " o' clock";
        }

        if (m == 15) {
            return "quarter past " + num[h];
        }

        if (m == 30) {
            return "half past " + num[h];
        }

        if (m < 30) {
            return num[m] + " minutes past " + num[h];
        }

        int nextHour = h + 1;
        if (nextHour == 12) {
            nextHour = 12;
        }

        if (m == 45) {
            return "quarter to " + num[nextHour];
        }

        return num[60 - m] + " minutes to " + num[nextHour];
    }
}