class Solution {
    public static long nonFibonacci(long n) {
        long prev = 3;
        long curr = 5;

        while (n > 0) {
            long gap = curr - prev - 1;

            if (n <= gap) {
                return prev + n;
            }

            n -= gap;
            long next = prev + curr;
            prev = curr;
            curr = next;
        }

        return 0;
    }
}
