import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            
            double sum = 0;
            for (int i = k; i < n - k; i++) {
                sum += a[i];
            }

            double average = sum / (n - 2 * k);
            System.out.printf("%.6f%n", average);
        }
    }
}
