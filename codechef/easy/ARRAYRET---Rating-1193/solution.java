import java.util.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] b = new long[n];
            long totalSumB = 0;
            
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextLong();
                totalSumB += b[i];
            }
            
            // Sum of array A
            long sumA = totalSumB / (n + 1);
            
            // Recovering and printing array A
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append((b[i] - sumA)).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        
        scanner.close();
    }
}