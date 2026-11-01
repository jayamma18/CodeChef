class Solution {
    public int findNthDigit(int n) {
        int length = 1;
        long count = 9;
        long start = 1;
        
        // Step 1: Identify the length of the numbers where the nth digit falls
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        
        // Step 2: Find the exact number that contains the nth digit
        long targetNum = start + (n - 1) / length;
        
        // Step 3: Find the exact digit within that target number
        String numStr = Long.toString(targetNum);
        int digitIndex = (n - 1) % length;
        
        return numStr.charAt(digitIndex) - '0';
    }
}
