import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            while (a < b)
                a = a * 2;

            while (b < a)
                b = b * 2;

            if (a == b)
                System.out.println("YES");
            else
                System.out.println("NO");
        } // Added this missing closing brace for the while loop
        
        sc.close();
	} // Added this missing closing brace for the main method
}