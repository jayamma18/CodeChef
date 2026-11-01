class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open brackets remaining
        int maxOpen = 0; // Maximum possible open brackets remaining
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--; // If * acts as ')'
                maxOpen++; // If * acts as '('
            }
            
            // If maxOpen is negative, there are too many closing brackets ')' 
            // than can ever be balanced by '(' or '*'
            if (maxOpen < 0) {
                return false;
            }
            
            // minOpen cannot drop below 0 because we cannot carry over 
            // "negative" open brackets to the next characters
            if (minOpen < 0) {
                minOpen = 0;
            }
        }
        
        // The string is valid if we can successfully finish with 0 open brackets
        return minOpen == 0;
    }
}
