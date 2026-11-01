class Solution {
    public String remConsonants(String s) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
