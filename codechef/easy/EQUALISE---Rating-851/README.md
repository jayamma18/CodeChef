# EQUALISE - Rating 851

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Make A and B equal

Chef has two numbers $A$ and $B$.

In one operation, Chef can choose either $A$ or $B$ and multiply it by $2$.

Determine whether he can make both $A$ and $B$ equal after any number (possibly, zero) of moves.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two space-separated integers $A$ and $B$.
### Output Format

For each test case, output `YES` if Chef can make both numbers equal, `NO` otherwise.

Note that the checker is case-insensitive i.e. `YES`, `Yes`, `yes`, `yES` are all considered same.

### Constraints
- $1 \leq T \leq 2500$
- $1 \leq A, B \leq 50$
### Sample 1:
Input
Output

```
4
5 20
6 6
12 2
50 20

```

```
YES
YES
NO
NO

```

### Explanation:

 **Test case $1$:**  Chef can multiply $A$ by $2$ twice and both $A$ and $B$ will become $20$.

 **Test case $2$:**  Both numbers are already equal.

 **Test case $3$:**  It can be shown that $A$ and $B$ cannot be made equal.

 **Test case $4$:**  It can be shown that $A$ and $B$ cannot be made equal.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T13:02:37.446Z  

```java
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
```

---

[View on CodeChef](https://www.codechef.com/problems/EQUALISE)