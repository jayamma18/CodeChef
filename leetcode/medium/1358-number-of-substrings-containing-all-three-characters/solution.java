import java.util.Arrays;

class Solution {
    public int numberOfSubstrings(String s) {
        // Array to keep track of the last seen index of 'a', 'b', and 'c'
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1); // Initialize positions with -1
        
        int totalSubstrings = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // Update the last seen position of the current character
            lastSeen[s.charAt(i) - 'a'] = i;
            
            // If all three characters have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the smallest index among the three last seen positions
                int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                
                // Every starting position from index 0 up to minIndex creates a valid substring
                totalSubstrings += minIndex + 1;
            }
        }
        
        return totalSubstrings;
    }
}
