class Solution {
    public String reverseWords(String s) {
        // Split the string by dots using an escaped regex
        String[] words = s.split("\\.");
        StringBuilder result = new StringBuilder();

        // Traverse the words array from right to left
        for (int i = words.length - 1; i >= 0; i--) {
            // Ignore empty tokens caused by leading, trailing, or multiple dots
            if (!words[i].isEmpty()) {
                if (result.length() > 0) {
                    result.append(".");
                }
                result.append(words[i]);
            }
        }

        return result.toString();
    }
}
