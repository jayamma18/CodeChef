# NUM239 - Rating 873

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Counting Pretty Numbers

Vasya likes the number $239$. Therefore, he considers a number  *pretty*  if its last digit is $2$, $3$ or $9$.

Vasya wants to watch the numbers between $L$ and $R$ (both inclusive), so he asked you to determine how many pretty numbers are in this range. Can you help him?

### Input
- The first line of the input contains a single integer $T$ denoting the number of test cases. The description of $T$ test cases follows.
- The first and only line of each test case contains two space-separated integers $L$ and $R$.
### Output

For each test case, print a single line containing one integer — the number of pretty numbers between $L$ and $R$.

### Constraints
- $1 \le T \le 100$
- $1 \le L \le R \le 10^5$
### Subtasks

 **Subtask #1 (100 points):**  original constraints

### Sample 1:
Input
Output

```
2
1 10
11 33
```

```
3
8
```

### Explanation:

 **Example case 1:**  The pretty numbers between $1$ and $10$ are $2$, $3$ and $9$.

 **Example case 2:**  The pretty numbers between $11$ and $33$ are $12$, $13$, $19$, $22$, $23$, $29$, $32$ and $33$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T08:48:04.885Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            System.out.println(countPrettyNumbers(L, R));
        }
        
        sc.close();
	}
	public static int countPrettyNumbers(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            int lastDigit = i % 10;
            if (lastDigit == 2 || lastDigit == 3 || lastDigit == 9) {
                count++;
            }
        }
        return count;
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/NUM239)