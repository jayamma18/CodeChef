class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // A number with 'num' digits can have a maximum digit sum of 9 * num
        if (sum > 9L * num) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder(num);
        
        // Count how many 9s we can form
        int count9 = sum / 9;
        int remainder = sum % 9;
        
        // Append all the 9s to the front
        for (int i = 0; i < count9; i++) {
            sb.append('9');
        }
        
        // Append the remainder digit if it exists
        if (remainder > 0) {
            sb.append(remainder);
        }
        
        // Fill the rest of the positions with 0s to satisfy the exact 'num' digits requirement
        while (sb.length() < num) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}
