import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int a[]=new int[t];
		for(int i=0;i<t;i++){
		    a[i]=sc.nextInt();
		}
		int c=sc.nextInt();
		int d=sc.nextInt();
		int c0=0;
		for(int i=0;i<t;i++){
		    if(Math.abs(a[i]-c)<=d){
		        c0++;
		    }
		}
		if(c0==0){
		    System.out.println(-1);
		}
		else{
		    System.out.println(c0);
		}

	}
}
