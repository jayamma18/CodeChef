class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int neededRight = 0; // Number of closing parentheses required
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // If we need an odd number of right parentheses, it means 
                // we have a single unmatched ')'. We must insert 1 ')' to complete it.
                if (neededRight % 2 != 0) {
                    insertions++;
                    neededRight--; // Now it's balanced up to this point
                }
                neededRight += 2; // Each '(' needs two ')'
            } else { // c == ')'
                neededRight--;
                
                // If neededRight drops below 0, it means we got an unexpected ')'
                if (neededRight < 0) {
                    insertions++;    // Insert 1 '(' to match the incoming pair
                    neededRight += 2; // A '(' gives 2 needed, and we just consumed 1, so add 2
                }
            }
        }
        
        // Any remaining needed right parentheses must be inserted at the end
        return insertions + neededRight;
    }
}
