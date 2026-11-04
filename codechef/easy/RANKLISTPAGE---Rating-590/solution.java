import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int x = sc.nextInt();
                
                // Using the ceiling formula: (x + divisor - 1) / divisor
                int pageNumber = (x + 24) / 25;
                
                System.out.println(pageNumber);
            }
        }
        sc.close();
    }
}