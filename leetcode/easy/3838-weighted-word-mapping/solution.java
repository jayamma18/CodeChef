class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            int totalWeight = 0;
            
            // Calculate the total weight of the current word
            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                totalWeight += weights[charIndex];
            }
            
            // Take the total weight modulo 26
            int rem = totalWeight % 26;
            
            // Map to lowercase English letter using reverse alphabetical order
            char mappedChar = (char) ('z' - rem);
            sb.append(mappedChar);
        }
        
        return sb.toString();
    }
}
