class Solution {
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Compare characters from both ends moving towards the center
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }

        return true; // All characters matched perfectly
    }
}
