# CS2023_STK - Rating 1009

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### CodeChef Streak

CodeChef offers a feature called  *streak count*. A streak is maintained if you solve  **at least one**  problem daily.

Om and Addy actively maintain their streaks on CodeChef. Over a span of $N$ consecutive days, you have observed the count of problems solved by each of them.

Your task is to determine the  **maximum**  streak achieved by Om and Addy and find who had the longer maximum streak.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line of each test case contains an integer $N$ — the number of days. The second line of each test case contains $N$ space-separated integers, the $i^{th}$ of which is $A_i$, representing the problems solved by Om on the $i^{th}$ day. The third line of each test case contains $N$ space-separated integers, the $i^{th}$ of which is $B_i$, representing the problems solved by Addy on the $i^{th}$ day.
### Output Format

For each test case, output:

- OM, if Om has longer maximum streak than Addy;
- ADDY, if Addy has longer maximum streak than Om;
- DRAW, if both have equal maximum streak.

You may print each character in uppercase or lowercase. For example, `OM`, `om`, `Om`, and `oM`, are all considered the same.

### Constraints
- $1 \leq T \leq 10^{5}$
- $1 \leq N \leq 10^{5}$
- $0 \leq A_i, B_i \leq 10^{9}$
- The sum of $N$ over all test cases won't exceed $6\cdot 10^{5}$.
### Sample 1:
Input
Output

```
3
6
1 7 3 0 2 13
0 2 3 4 5 0
3
1 3 4
3 1 2
5
1 2 3 0 1
1 2 0 2 3
```

```
Addy
Draw
Om
```

### Explanation:

 **Test case $1$:**  Om has a maximum streak of $3$ days, while Addy has a maximum streak of $4$ days.

 **Test case $2$:**  Both have the same maximum streak of $3$ days.

 **Test case $3$:**  Addy has a maximum streak of $2$ days and Om has a maximum streak of $3$ days.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T08:57:56.269Z  

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int t = s.nextInt(); t-- > 0; ) {
            int n = s.nextInt(), om = 0, addy = 0;
            for (int i = 0, c = 0; i < n; i++) om = Math.max(om, c = s.nextInt() > 0 ? c + 1 : 0);
            for (int i = 0, c = 0; i < n; i++) addy = Math.max(addy, c = s.nextInt() > 0 ? c + 1 : 0);
            System.out.println(om > addy ? "OM" : om < addy ? "ADDY" : "DRAW");
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/CS2023_STK)