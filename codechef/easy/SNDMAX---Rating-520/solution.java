import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            System.out.println(a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));
        }
    }
}