import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int j=n*x;
            if(j>=10000 && j<=99999)
            System.out.println("YES");
            else
            System.out.println("NO");// Your code goes here
        }
    }
}
