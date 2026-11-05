class Solution {
    static int fullPrime(int N) {
        if (N <= 1) return 0;
        
        int temp = N;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 2 && digit != 3 && digit != 5 && digit != 7) {
                return 0;
            }
            temp /= 10;
        }
        
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) return 0;
        }
        
        return 1;
    }
}
