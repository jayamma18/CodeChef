# RANKLISTPAGE - Rating 590

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Ranklist Pages

Chef participated in a contest and got a rank $X$.

Chef is trying to find his name in the ranklist but there are too many pages.

Each page consists of $25$ participants. Chef wants to find the exact page number which contains his name.
Help Chef find the page number.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of a single integer $X$ - denoting the rank of Chef.
### Output Format

For each test case, output the page number of the ranklist containing Chef's name.

### Constraints
- $1 \leq T \leq 1000$
- $1 \leq X \leq 1000$
### Sample 1:
Input
Output

```
4
1
34
150
74

```

```
1
2
6
3

```

### Explanation:

 **Test case $1$:**  Since each page has $25$ participants, the first page has participants with rank $1$ to $25$. Thus, Chef can find his name in page number $1$.

 **Test case $2$:**  Since each page has $25$ participants, the first page has participants with rank $1$ to $25$ and the second page has participants with rank $26$ to $50$. Thus, Chef can find his name in page number $2$.

 **Test case $3$:**  Chef will find his name in page number $6$. The sixth page consists of participants with ranks $126$ to $150$.

 **Test case $4$:**  Chef will find his name in page number $3$. The third page consists of participants with ranks $51$ to $75$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T13:07:39.185Z  

```java
import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int x = sc.nextInt();
                
                // Using the ceiling formula: (x + divisor - 1) / divisor
                int pageNumber = (x + 24) / 25;
                
                System.out.println(pageNumber);
            }
        }
        sc.close();
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/RANKLISTPAGE)