import java.util.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        if (!scanner.hasNextInt()) return;
        int T = scanner.nextInt();
        
        while (T-- > 0) {
            int n = scanner.nextInt();
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                // We want the strictly first occurrence of the minimum value,
                // so we use '<' instead of '<='
                if (x < minVal) {
                    minVal = x;
                    minIndex = i + 1; // 1-based indexing
                }
            }
            System.out.println(minIndex);
        }
        scanner.close();
    }
}