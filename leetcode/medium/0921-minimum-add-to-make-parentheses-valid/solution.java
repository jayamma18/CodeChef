class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int closeNeeded = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                openNeeded++;
            } else { // c == ')'
                if (openNeeded > 0) {
                    openNeeded--; // Matched a valid pair
                } else {
                    closeNeeded++; // Unmatched closing parenthesis
                }
            }
        }
        
        return openNeeded + closeNeeded;
    }
}
