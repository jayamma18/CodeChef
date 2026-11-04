# BALLBOX - Rating 994

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Balls and Boxes

You have $N$ balls and $K$ boxes. You want to divide the $N$ balls into $K$ boxes such that:

- Each box contains $\ge 1$ balls.
- No two boxes contain the same number of balls.

Determine if it is possible to do so.

### Input Format
- The first line contains a single integer $T$ — the number of test cases. Then the test cases follow.
- The first and only line of each test case contains two space-separated integers $N$ and $K$ — the number of balls and the number of boxes respectively.
### Output Format

For each test case, output `YES` if it is possible to divide the $N$ balls into $K$ boxes such that the conditions are satisfied. Otherwise, output `NO`.

You may print each character of `YES` and `NO` in uppercase or lowercase (for example, `yes`, `yEs`, `Yes` will be considered identical).

### Constraints
- $1 \leq T \leq 10^5$
- $1 \le N \le 10^9$
- $1 \le K \le 10^4$
### Sample 1:
Input
Output

```
4
3 4
30 3
2 2
1 1

```

```
NO
YES
NO
YES

```

### Explanation:

 **Test Case 1:**  It is not possible to divide the $3$ balls into $4$ boxes such that each box contains $\ge 1$ balls.

 **Test Case 2:**  One way to divide the $30$ balls into $3$ boxes is the following: $[5, 9, 16]$.

 **Test Case 3:**  It is not possible to divide the $2$ balls into $2$ boxes such that no two boxes contain the same number of balls.

 **Test Case 4:**  We can divide $1$ ball into $1$ box.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T12:54:30.124Z  

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
		    int N = sc.nextInt();
            int K = sc.nextInt();

           long minBalls = K * (K + 1) / 2;

            if (N >= minBalls)
                System.out.println("YES");
            else
                System.out.println("NO");
		}

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/BALLBOX)