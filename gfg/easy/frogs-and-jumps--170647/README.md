# Frogs and Jumps

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Frogs are positioned at one end of a pond, and each wants to reach the other end. The pond has some leaves arranged in a straight line.

Each frog has a strength  **s**, meaning it jumps exactly  **s** leaves at a time - for example, a frog with strength 2 visits leaves 2, 4, 6, and so on while crossing the pond.

Given the strength of each frog (as an array  **arr[]**) and the total number of leaves  **k**, find how many leaves are not visited by any frog after all frogs have crossed the pond.

 **Examples:** 

```
Input: arr[] = [3, 2, 4], k = 4
Output: 1
Explanation: Frog with strength 3 visits leaf 3. Frog with strength 2 visits leaves 2, 4. Frog with strength 4 visits leaf 4. Leaf 1 is never visited by any frog.
```

```
Input: arr[] = [1, 3, 5], k = 6
Output: 0
Explanation: Frog with strength 1 visits leaves 1, 2, 3, 4, 5, 6 every leaf. All leaves are already covered, so none are left unvisited.
```

 **Constraints:** 
1 ≤ n, k, arr[i] ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-19T09:55:03.827Z  

```java
class Solution {
    int unvisitedLeaves(int arr[], int k) {
        boolean[] visited = new boolean[k + 1];
        for (int s : arr) {
            for (int j = s; j <= k; j += s) {
                visited[j] = true;
            }
        }
        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (!visited[i]) count++;
        }
        return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/frogs-and-jumps--170647/1)