import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Added missing parentheses ()
        
        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine()); 
            String[] input = scanner.nextLine().split(" "); 
            
            int maxElement = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                maxElement = Math.max(maxElement, Integer.parseInt(input[i])); 
            }

            System.out.println(maxElement); 
        }
        
        scanner.close();
    }
}