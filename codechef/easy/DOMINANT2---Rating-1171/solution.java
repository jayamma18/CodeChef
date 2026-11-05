import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] counts = new int[n + 1];
            
            for (int i = 0; i < n; i++) {
                counts[sc.nextInt()]++;
            }
            
            Arrays.sort(counts);
            
            if (counts[n] > counts[n - 1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
