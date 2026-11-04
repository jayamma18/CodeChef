# BUDTECH - Rating 449

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Budget of Technex

The budget of Technex'23 is $R$ thousand rupees. Since ICM is their flagship event, they will allocate  **at least half**  of their budget to it.

There are $5$ other events planned under Technex'23.
The team wants to distribute the remaining amount  **equally**  among these.
Find the  **maximum**  amount in rupees that could be allocated to each of the other five events.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- The first and only line of each test case contains a single integer $R$, the budget of Technex'23 in thousand rupees.
### Output Format

For each test case, output a single integer on a new line, the  **maximum**  amount in rupees that could be allocated to each of the other five events.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq R \leq 3000$
### Sample 1:
Input
Output

```
3
20
43
133
```

```
2000
4300
13300
```

### Explanation:

 **Test case $1$:**  The budget of Technex'23 is $20000$ rupees. If ICM is allocated $10000$ rupees and the remaining $10000$ rupees is distributed among the other events, each will have a budget of $2000$ rupees, which is the maximum possible.

 **Test case $2$:**  The budget of Technex'23 is $43000$ rupees. If $21500$ rupees is allocated to ICM, the rest of the events can each be alloted $4300$ rupees.

 **Test case $3$:**  The budget of Technex'23 is $133000$ rupees. If $66500$ rupees is allocated to ICM, the rest of the events can each be alloted $13300$ rupees.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T13:23:21.649Z  

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
		while(t-- >0)
		{
		int a=sc.nextInt();
		a=a*100;
		System.out.println(a);
		}// your code goes here

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/BUDTECH)