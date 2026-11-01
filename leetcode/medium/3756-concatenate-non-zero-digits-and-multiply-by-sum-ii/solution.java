class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007L;

        // Prefix arrays
        int[] cnt = new int[m + 1];
        long[] sum = new long[m + 1];
        long[] val = new long[m + 1];
        long[] power10 = new long[m + 1];

        power10[0] = 1;
        for (int i = 1; i <= m; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        // Build prefix arrays
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            int digit = ch - '0';

            if (digit != 0) {
                cnt[i + 1] = cnt[i] + 1;
                sum[i + 1] = sum[i] + digit;
                val[i + 1] = (val[i] * 10 + digit) % MOD;
            } else {
                cnt[i + 1] = cnt[i];
                sum[i + 1] = sum[i];
                val[i + 1] = val[i]; // No change in value magnitude if it's '0'
            }
        }

        int numQueries = queries.length;
        int[] answer = new int[numQueries];

        for (int q = 0; q < numQueries; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            // 1. Get the number of non-zero elements in the range
            int k = cnt[r + 1] - cnt[l];

            if (k == 0) {
                answer[q] = 0;
                continue;
            }

            // 2. Get the sum of digits in the range
            long digitSum = (sum[r + 1] - sum[l]) % MOD;

            // 3. Extract the exact value of x using prefix subtraction
            long x = (val[r + 1] - (val[l] * power10[k]) % MOD + MOD) % MOD;

            // 4. Combine and compute result
            answer[q] = (int) ((x * digitSum) % MOD);
        }

        return answer;
    }
}
