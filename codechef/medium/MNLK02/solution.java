import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		if(s1.length()!=s2.length()){
		    System.out.println("false");
		    return;
		}
		int c[]=new int[26];
		for(int i=0;i<s1.length();i++){
		    c[s1.charAt(i) - 'a']++;
		    c[s2.charAt(i) - 'a']--;
		}
		boolean flag=true;
		for(int i=0;i<26;i++){
		    if(c[i]!=0){
		        flag=false;
		        break;
		    }
		}
		System.out.println(flag);

	}
}
