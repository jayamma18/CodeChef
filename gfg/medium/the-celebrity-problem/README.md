# Celebrity Problem

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Consider a party being organized by some people. A celebrity is a person who is known to all but does not know anyone at the party. 

- A square matrix mat[][] of size n * n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person.
- You need to return index of the celebrity in the party.
- If the celebrity does not exist, return -1.

 **Note:**  Follow 0-based indexing.

 **Examples:** 

```
Input: mat[][] = [[1, 1, 0],
                 [0, 1, 0],
                 [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person and 1st person does not know anyone. Therefore, 1 is the celebrity person.
```

```
Input: mat[][] = [[1, 1], 
                 [1, 1]]
Output: -1
Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.
```

```
Input: mat[][] = [[1]]
Output: 0
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T12:35:22.236Z  

```java
class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int[][] mat) {
        int n = mat.length;

        // Step 1: Find the celebrity candidate using two pointers
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (mat[left][right] == 1) {
                // left knows right -> left cannot be the celebrity
                left++;
            } else {
                // left does not know right -> right cannot be the celebrity
                right--;
            }
        }

        // Candidate found at index 'left'
        int candidate = left;

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // A celebrity must NOT know anyone (mat[candidate][i] should be 0)
                // Everyone else MUST know the celebrity (mat[i][candidate] should be 1)
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1)