import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        while (n-- > 0) {
            int[] nums = new int[3];
            nums[0] = scanner.nextInt();
            nums[1] = scanner.nextInt();
            nums[2] = scanner.nextInt();
            Arrays.sort(nums); 
            System.out.println(nums[1]); 
        }
        scanner.close();
    }
}