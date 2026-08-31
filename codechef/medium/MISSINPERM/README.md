# MISSINPERM

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Missing number in permutation

Given a  **permutation**  of $n$ distinct numbers chosen from the range $[0, n]$, find the  **one missing number**  that does not appear in the array.

## What is a Permutation?

A  **permutation**  is a rearrangement of elements in a set.

- Example: If the set is ${0, 1, 2, 3}$, then $[3, 1, 0, 2]$ is a permutation because it contains all elements exactly once in some order.
- In this problem, the array represents a permutation of $n$ numbers from $[0, n]$, except that one element is missing.
## Function Declaration
### Function Name

$missingNumber$ – This function finds the missing number in a permutation.

### Parameters
- $nums$ : An array of $n$ distinct integers taken from the range $[0, n]$.
### Return Value
- Returns a single integer — the missing number from the permutation.
## Constraints
- $1 \leq T \leq 100$
- $n == nums.length$
- $1 \leq n \leq 10^4$
- $0 \leq nums[i] \leq n$
- All elements in $nums$ are unique
## Follow-up

Can you solve this in  **O(n) time**  and  **O(1) extra space** ?

### Input Format
- The first line contains a single integer $T$ — the number of test cases.
- For each test case: The first line contains a single integer $N$ — the size of the array. The second line contains $N$ space-separated integers representing the permutation array.
### Output Format
- For each test case, print the missing number on a new line.
### Sample 1:
Input
Output

```
3
2
2 0
4
4 2 1 0
3
1 2 3

```

```
1
3
0
```

### Explanation:
- In the first test case the numbers should form a permutation of [0,1,2], but 1 is missing.
- In the second test case the numbers should form a permutation of [0, 1, 2, 3, 4], but 3 is missing.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T09:10:22.637Z  

```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0, sum2 = 0;

        // Sum of array elements
        for (int num : nums) {
            sum1 += num;
        }

        // Sum of numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            sum2 += i;
        }

        // Missing number is the difference
        return Math.abs(sum2 - sum1);
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/MISSINPERM)