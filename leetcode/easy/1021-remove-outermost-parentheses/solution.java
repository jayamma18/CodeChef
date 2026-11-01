class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // Only append if it's not the outermost opening parenthesis
                if (openCount > 0) {
                    result.append(c);
                }
                openCount++;
            } else { // c == ')'
                openCount--;
                // Only append if it's not the outermost closing parenthesis
                if (openCount > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}
