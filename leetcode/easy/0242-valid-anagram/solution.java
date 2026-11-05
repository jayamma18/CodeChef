import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        // Sort both arrays alphabeticaly
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        // If sorted arrays are identical, it is an anagram
        return Arrays.equals(sArray, tArray);
    }
}
