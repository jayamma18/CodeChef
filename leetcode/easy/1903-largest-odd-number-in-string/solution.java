class Solution {
    public String largestOddNumber(String num) {
        // Scan the string from right to left (backwards)
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            
            // As soon as we find the first odd digit from the right
            if (digit % 2 != 0) {
                // Return the substring from the beginning up to this digit (inclusive)
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return an empty string
        return "";
    }
}
