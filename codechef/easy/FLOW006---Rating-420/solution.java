import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- >0){
		    int n=sc.nextInt();
		    int s=0;
		    while(n>0){
		        s+=(n%10);
		        n/=10;
		    }
		    System.out.println(s);
		}// your code goes here

	}
}
