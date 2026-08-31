import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // your code goes here
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int num = scanner.nextInt();
            arr[i] = num;
        }
        
        int[] pre = new int[len];
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                pre[i] += pre[i - 1];
            }
            pre[i] += arr[i];
        }
        
        for (int e : pre) {
            System.out.print(e + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
