# ARRAYRET - Rating 1193

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Retrieve the Array

Chef has an array $A$ of length $N$.

Let $f(i)$ denote the sum $A_1 + A_2 + \dots + A_i \,$ and let $g(i)$ denote the sum $A_i + A_{i + 1} + \dots + A_N$.

Chef creates another array $B$ of length $N$ such that $B_i = f(i) + g(i)$ for all $1 \leq i \leq N$.

Now, Chef has lost the original array $A$ and needs your help to recover it, given array $B$. It is guaranteed that Chef has obtained the array $B$ from a valid array $A$.

### Input Format
- The first line contains a single integer $T$ — the number of test cases. Then the test cases follow.
- The first line of each test case contains an integer $N$ — the size of the array $A$.
- The second line of each test case contains $N$ space-separated integers $B_1, B_2, \dots, B_N$ denoting the array $B$.
### Output Format

For each testcase, output $N$ space separated integers $A_1, A_2, \dots, A_N$ denoting the array $A$.

Note that $1 \leq A_i \leq 10^5$ must hold for all $1 \leq i \leq N$ and it is guaranteed that a valid array $A$ that meets these constraints exists.

If there are multiple answers, output any.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq N \leq 10^5$
- $1 \leq B_i \leq 2 \cdot 10^{10}$
- Th sum of $N$ over all test cases does not exceed $10^5$.
- $1 \leq A_i \leq 10^5$
- It is guaranteed that a valid array $A$ always exists.
### Sample 1:
Input
Output

```
4
1
6
3
7 8 9
4
13 15 13 14
2
25 20

```

```
3 
1 2 3 
2 4 2 3 
10 5 

```

### Explanation:

 **Test case 1:**  For $A = [3]$, $B = [6]$. $B_1 = f(1) + g(1) = 3 + 3 = 6$.

 **Test case 2:**  For $A = [1, 2, 3]$, $B = [7, 8, 9]$.

- $B_1 = f(1) + g(1) = \underline{1} + \underline{1 + 2 + 3} = 7$
- $B_2 = f(2) + g(2) = \underline{1 + 2} + \underline{2 + 3} = 8$
- $B_3 = f(3) + g(3) = \underline{1 + 2 + 3} + \underline{3} = 9$

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T08:42:18.755Z  

```java
import java.util.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] b = new long[n];
            long totalSumB = 0;
            
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextLong();
                totalSumB += b[i];
            }
            
            // Sum of array A
            long sumA = totalSumB / (n + 1);
            
            // Recovering and printing array A
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append((b[i] - sumA)).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        
        scanner.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/ARRAYRET)