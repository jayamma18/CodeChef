# SINGLENUM

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Single number in multiple numbers

You are given a  **non-empty**  array of integers $nums$.
In this array, every number occurs  **exactly twice**  except for one number that occurs only once.
Your task is to find and return that unique number.

The solution must run in  **O(n)**  time complexity and use  **O(1)**  space complexity.

## Function Declaration
### Function Name

$singleNumber$ – Finds the one number in the array that appears exactly once while all other numbers appear twice.

### Parameters
- $nums$ : A list/array of integers where every value appears exactly twice except one.
### Return Value
- Returns an integer — the unique number that appears only once.
## Constraints:
- $1 \leq nums.length \leq 3 * 10^4$
- $-3  *10^4 \leq nums[i] \leq 3*  10^4$
- Exactly one element in the array appears once, and all others appear twice.
### Input Format
- $N$ → number of elements in the array
- Next line → N integers representing $nums$
### Output Format
- Print the single number that appears exactly once.
### Sample 1:
Input
Output

```
3
1
10
5
9 1 9 2 1
5
7 3 5 3 7
```

```
10
2
5
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T09:10:32.597Z  

```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR accumulates the unique number
        }
        return result;
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/SINGLENUM)