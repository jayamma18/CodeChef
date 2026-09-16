class Solution {
    public static String snakeCase(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                result.append('_');
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}