class Solution {
    public int findGcd(int n, int x, int y) {
        // 1. Calculate the GCD of repetitions (x and y)
        int a = x, b = y;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int repetitions = a;

        // 2. Repeat the number n that many times using built-in repeat()
        String res = String.valueOf(n).repeat(repetitions);

        // 3. Convert back to an integer and return
        return Integer.parseInt(res);
    }
}
