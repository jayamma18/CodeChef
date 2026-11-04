import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int x = sc.nextInt();
                boolean isLucky = false;
                
                // Working with a temporary variable to keep x intact if needed
                int temp = x;
                while (temp > 0) {
                    if (temp % 10 == 7) {
                        isLucky = true;
                        break;
                    }
                    temp /= 10;
                }
                
                if (isLucky) System.out.println("YES");
                else System.out.println("NO");
            }
        }

	}
}
