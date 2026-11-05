import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int t = s.nextInt(); t-- > 0; ) {
            int n = s.nextInt(), om = 0, addy = 0;
            for (int i = 0, c = 0; i < n; i++) om = Math.max(om, c = s.nextInt() > 0 ? c + 1 : 0);
            for (int i = 0, c = 0; i < n; i++) addy = Math.max(addy, c = s.nextInt() > 0 ? c + 1 : 0);
            System.out.println(om > addy ? "OM" : om < addy ? "ADDY" : "DRAW");
        }
    }
}