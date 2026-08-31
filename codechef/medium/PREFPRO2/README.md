# PREFPRO2

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Optimization Using Prefix Array

Given an array of length $n$, we need to perform $m$ query over the array.

In each query you need to find the sum of the element in the range $a$ to $b$.

### Without using prefix sum
- For each query we need to iterate over the length of array, which will take $O(n)$ time.
- Total m query will make the time complexity $O(n*m)$
### Using prefix sum
- Create an prefix sum array in $O(n)$ time.
- For each query we can find the sum of a range in $O(1)$ time, using $prefix[b] - prefix[a-1]$ as the sum of range from $a$ to $b$
- Total $m$ query will make the time complexity $m * O(1) + O(n)$ => $O(m) + O(n)$

We can see above clearly how prefix sum help us to optimize the time complexity of our code.

### Task

Use the optimized algorithm to solve the problem.

### Input Format
- First line contains an integer $N$, the length of the array.
- Second line contains $N$ elements a1, a2, a3.... ar$N$.
- Third line gives an integer $K$, the number of queries.
- Next $K$ line contains queries with integer a$i$ and b$i$.
### Constraints
- $1 \leq N \leq 100000$
- $1 \leq arr_i \leq 100000$
- $1 \leq K \leq 100000$
- $1 \leq a_i, b_i \leq N$
### Sample 1:
Input
Output

```
5
1 2 3 4 5 
5
1 2
2 3
2 4
4 4
1 5
```

```
3
5
9
4
15

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T08:49:50.673Z  

```java
import java.util.Scanner;
import java.util.Vector;

class Codechef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        Vector<Integer> ar = new Vector<>();
        for (int i = 0; i < len; i++) {
            int n1 = scanner.nextInt();
            ar.add(n1);
        }
        
        long[] pre = new long[len];
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                pre[i] += pre[i - 1];
            }
            pre[i] += ar.get(i);
        }
        
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            n1--;
            n2--;
            if (n1 == 0) {
                System.out.println(pre[n2]);
            } else {
                System.out.println(pre[n2] - pre[n1 - 1]);
            }
        }
        
        scanner.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/PREFPRO2)