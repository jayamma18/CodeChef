# FLOW006 - Rating 420

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Sum of Digits

You're given an integer  **N**. Write a program to calculate the sum of all the digits of  **N**.

### Input Format

The first line contains an integer  **T**, the total number of testcases. Then follow  **T**  lines, each line contains an integer  **N**.

### Output Format

For each test case, calculate the sum of digits of  **N**, and display it in a new line.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq N \leq 1000000$
### Sample 1:
Input
Output

```
3 
12345
31203
2123

```

```
15
9
8

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T12:53:05.851Z  

```java
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

```

---

[View on CodeChef](https://www.codechef.com/problems/FLOW006)