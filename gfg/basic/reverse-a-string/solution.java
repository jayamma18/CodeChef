class Solution {
    public static String reverseString(String s) {
        // Base case: if string is empty or single character, return it as is
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        // Two-pointer swap approach
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}
