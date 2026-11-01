import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int openRem = 0;  // Count of '(' that MUST be removed
        int closeRem = 0; // Count of ')' that MUST be removed
        
        // Pass 1: Calculate the minimum number of invalid '(' and ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openRem++;
            } else if (c == ')') {
                if (openRem > 0) {
                    openRem--; // Matched valid pair
                } else {
                    closeRem++; // Unmatched close parenthesis
                }
            }
        }
        
        Set<String> validStrings = new HashSet<>();
        backtrack(s, 0, 0, openRem, closeRem, new StringBuilder(), validStrings);
        return new ArrayList<>(validStrings);
    }
    
    private void backtrack(String s, int index, int balance, int openRem, int closeRem, StringBuilder sb, Set<String> result) {
        // If balance drops below 0, the current configuration is invalid
        if (balance < 0) {
            return;
        }
        
        // Base case: processed entire string
        if (index == s.length()) {
            if (openRem == 0 && closeRem == 0 && balance == 0) {
                result.add(sb.toString());
            }
            return;
        }
        
        char c = s.charAt(index);
        int length = sb.length();
        
        if (c == '(') {
            // Option 1: Remove the '(' if we still need to delete some
            if (openRem > 0) {
                backtrack(s, index + 1, balance, openRem - 1, closeRem, sb, result);
            }
            // Option 2: Keep the '('
            sb.append(c);
            backtrack(s, index + 1, balance + 1, openRem, closeRem, sb, result);
            sb.setLength(length); // Backtrack step
            
        } else if (c == ')') {
            // Option 1: Remove the ')' if we still need to delete some
            if (closeRem > 0) {
                backtrack(s, index + 1, balance, openRem, closeRem - 1, sb, result);
            }
            // Option 2: Keep the ')'
            sb.append(c);
            backtrack(s, index + 1, balance - 1, openRem, closeRem, sb, result);
            sb.setLength(length); // Backtrack step
            
        } else {
            // Non-parenthesis characters (like letters) are always kept
            sb.append(c);
            backtrack(s, index + 1, balance, openRem, closeRem, sb, result);
            sb.setLength(length); // Backtrack step
        }
    }
}
