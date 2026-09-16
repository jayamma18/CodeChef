class Solution {
    public static String[] splitString(String S) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        StringBuilder special = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (Character.isLetter(ch)) {
                letters.append(ch);
            } else if (Character.isDigit(ch)) {
                digits.append(ch);
            } else {
                special.append(ch);
            }
        }

        String[] result = new String[3];

        result[0] = letters.length() == 0 ? "-1" : letters.toString();
        result[1] = digits.length() == 0 ? "-1" : digits.toString();
        result[2] = special.length() == 0 ? "-1" : special.toString();

        return result;
    }
}