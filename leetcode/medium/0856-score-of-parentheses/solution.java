class Solution {
    public int scoreOfParentheses(String s) {
        int depth = 0;
        int score = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                // If the previous character was '(', we found a core "()" primitive
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth; // equivalent to adding 2^depth
                }
            }
        }
        
        return score;
    }
}
