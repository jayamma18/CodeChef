# DISTINCTCOL - Rating 760

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Distinct Colors

There are $N$ different types of colours numbered from $1$ to $N$. Chef has $A_i$ balls having colour $i$, $(1\le i \le N)$.

Chef will arrange some boxes and put each ball in  **exactly one**  of those boxes.
Find the  **minimum**  number of boxes Chef needs so that  **no**  box contains  **two**  balls of same colour.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases. The description of the test cases follows.
- The first line of each test case contains a single integer $N$, denoting the number of colors.
- The second line of each test case contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$ — denoting the number of balls having colour $i$.
### Output Format

For each test case, output the  **minimum**  number of boxes required so that no box contains two balls of same colour.

### Constraints
- $1 \leq T \leq 1000$
- $2 \leq N \leq 100$
- $1 \leq A_i \leq 10^5$
### Sample 1:
Input
Output

```
3
2
8 5
3
5 10 15
4
4 4 4 4

```

```
8
15
4

```

### Explanation:

 **Test case $1$:**  Chef needs at least $8$ boxes such that no box has two balls of same colour. A possible configuration of the $8$ boxes would be $\{[1, 2], [1, 2], [1, 2], [1, 2], [1, 2], [1], [1], [1]\}$ where the $i^{th}$ element of this set denotes the colour of balls in the $i^{th}$ box.

 **Test case $2$:**  Chef needs at least $15$ boxes such that no box has two balls of same colour.

 **Test case $3$:**  Chef needs at least $4$ boxes such that no box has two balls of same colour. A possible configuration of the $4$ boxes would be $\{[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]\}$ where the $i^{th}$ element of this set denotes the colour of balls in the $i^{th}$ box.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T08:40:42.655Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Added missing parentheses ()
        
        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine()); 
            String[] input = scanner.nextLine().split(" "); 
            
            int maxElement = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                maxElement = Math.max(maxElement, Integer.parseInt(input[i])); 
            }

            System.out.println(maxElement); 
        }
        
        scanner.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/DISTINCTCOL)