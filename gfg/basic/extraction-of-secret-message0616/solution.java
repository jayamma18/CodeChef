class Solution {
    public static String extractMessage(String s) {
        return s.replaceAll("(LIE)+", " ").trim();
    }
}