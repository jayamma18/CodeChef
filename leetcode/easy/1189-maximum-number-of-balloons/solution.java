class Solution {
    public int maxNumberOfBalloons(String text) {
        // Frequency array for all 26 lowercase English letters
        int[] counts = new int[26];
        
        // Count characters in the input string
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }
        
        // Individual maximum instances based on each required letter
        int bCount = counts['b' - 'a'];
        int aCount = counts['a' - 'a'];
        int lCount = counts['l' - 'a'] / 2; // Requires 2 per word
        int oCount = counts['o' - 'a'] / 2; // Requires 2 per word
        int nCount = counts['n' - 'a'];
        
        // The bottleneck character determines the final max count
        return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));
    }
}
