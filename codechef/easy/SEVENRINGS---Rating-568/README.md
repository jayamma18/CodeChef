# SEVENRINGS - Rating 568

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### 7 Rings

In Chefland, a  *valid*  phone number consists of $5$ digits with  **no leading zeros**.
For example, $98765, 10000,$ and $71023$ are valid phone numbers while $04123, 9231,$ and $872310$ are not.

Chef went to a store and purchased $N$ items, where the cost of each item is $X$.
Find whether the total bill is equivalent to a  *valid*  phone number.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two space-separated integers $N$ and $X$ — the number of items Chef bought and the cost per item.
### Output Format

For each test case, output on a new line, `YES`, if the total bill is equivalent to a  *valid*  phone number and `NO` otherwise.

Each character of the output may be printed in either uppercase or lowercase. That is, the strings `NO`, `no`, `nO`, and `No` will be treated as equivalent.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq N, X \leq 1000$
### Sample 1:
Input
Output

```
4
25 785
402 11
100 100
333 333

```

```
YES
NO
YES
NO
```

### Explanation:

 **Test case $1$:**  Chef bought $25$ items, each with cost $785$. The total bill is thus, $25\cdot 785 = 19625$. Since the total bill amount is $5$ digits with no leading zeros, it is equivalent to a valid phone number.

 **Test case $2$:**  Chef bought $402$ items, each with cost $11$. The total bill is thus, $402\cdot 11 = 4422$. Since the total bill amount is of $4$ digits, it is not equivalent to a valid phone number.

 **Test case $3$:**  Chef bought $100$ items, each with cost $100$. The total bill is thus, $100\cdot 100 = 10000$. Since the total bill amount is $5$ digits with no leading zeros, it is equivalent to a valid phone number

 **Test case $4$:**  Chef bought $333$ items, each with cost $333$. The total bill is thus, $333\cdot 333 = 110889$. Since the total bill amount is of $6$ digits, it is not equivalent to a valid phone number.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T05:00:17.862Z  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int j=n*x;
            if(j>=10000 && j<=99999)
            System.out.println("YES");
            else
            System.out.println("NO");// Your code goes here
        }
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/SEVENRINGS)