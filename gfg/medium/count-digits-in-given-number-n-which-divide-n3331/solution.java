class Solution {
    public int divisibleByDigits(String s) {
        // divide[d] will store whether the full number is divisible by digit d
        boolean[] divide = new boolean[10];

        // 1 always divides any non-negative integer
        divide[1] = true;

        // Check divisibility for digits 2 to 9 using modular arithmetic
        for (int digit = 2; digit <= 9; digit++) {
            if (isDivisible(s, digit)) {
                divide[digit] = true;
            }
        }

        int count = 0;

        // Count how many individual digits in s divide the entire number
        for (int i = 0; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';
            if (currentDigit != 0 && divide[currentDigit]) {
                count++;
            }
        }

        return count;
    }

    // Helper function to check if the large string number is divisible by a single digit
    private boolean isDivisible(String s, int digit) {
        int remainder = 0;
        for (int i = 0; i < s.length(); i++) {
            int digitValue = s.charAt(i) - '0';
            remainder = (remainder * 10 + digitValue) % digit;
        }
        return remainder == 0;
    }
}
