class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        
        // Loop through each pattern and check if it's a substring of word
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        
        return count;
    }
}
