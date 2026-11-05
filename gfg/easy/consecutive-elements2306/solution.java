class Solution {
    public String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
