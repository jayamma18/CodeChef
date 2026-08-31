# MAXCOUNT - Rating 1180

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Count of Maximum

Given an array $A$ of length $N$, your task is to find the element which repeats in the array the maximum number of times, along with its exact frequency count.

If there is a tie (i.e multiple elements have the same maximum frequency), you must choose the  **smallest**  element among them.

## Function Declaration
### Function Name

$mostFrequent$ – This function processes the array and finds the required element and its count.

### Parameters

$N$ : An integer representing the length of the array $A$.
$A$ : An array (or list) of $N$ integers.

### Return Value

Returns an array/pair of two integers:

- The most frequent element (the smallest one in case of a tie).
- Its corresponding frequency count.
### Constraints:
- $1 \le T \le 100$
- $1 \le N \le 10^5$
- $1 \le A[i] \le 10^9$
- The sum of $N$ over all test cases does not exceed $2 \times 10^5$.

 *The input and output formats provided below are only for testing with custom inputs. You only need to complete the logic function. The parsing of inputs, looping over test cases, and final printing are handled automatically by the platform.* 

### Input Format
- The first line contains a single integer $T$, representing the number of test cases.
- For each test case: The first line contains a single integer $N$, representing the length of the array. The second line contains $N$ space-separated integers representing the elements of array $A$.
### Output Format
- For each test case, print two space-separated integers on a new line: the chosen element followed by its frequency count.
### Sample 1:
Input
Output

```
2
5
1 2 3 2 5
6
1 2 2 1 1 2
```

```
2 2
1 3
```

### Explanation:

In first case 2 occurs twice whereas all other elements occur only once. In second case, both 1 and 2 occur 3 times but 1 is smaller than 2.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-31T08:52:07.833Z  

```java
class Solution {
    public int[] mostFrequent(int N, int[] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int bestElem = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            int num = A[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            int num = entry.getKey();
            
            if (count > maxFreq) {
                maxFreq = count;
                bestElem = num;
            } else if (count == maxFreq && num < bestElem) {
                bestElem = num;
            }
        }
        
        return new int[]{bestElem, maxFreq};
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/MAXCOUNT)