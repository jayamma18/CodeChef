import java.util.Scanner;
import java.util.Vector;

class Codechef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        Vector<Integer> ar = new Vector<>();
        for (int i = 0; i < len; i++) {
            int n1 = scanner.nextInt();
            ar.add(n1);
        }
        
        long[] pre = new long[len];
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                pre[i] += pre[i - 1];
            }
            pre[i] += ar.get(i);
        }
        
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            n1--;
            n2--;
            if (n1 == 0) {
                System.out.println(pre[n2]);
            } else {
                System.out.println(pre[n2] - pre[n1 - 1]);
            }
        }
        
        scanner.close();
    }
}
