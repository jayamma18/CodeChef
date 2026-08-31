class Solution {
    public int[] mostFrequent(int N, int[] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int bestElem = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            int num = A[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            int num = entry.getKey();
            
            if (count > maxFreq) {
                maxFreq = count;
                bestElem = num;
            } else if (count == maxFreq && num < bestElem) {
                bestElem = num;
            }
        }
        
        return new int[]{bestElem, maxFreq};
    }
}