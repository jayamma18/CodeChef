# Quadratic Equation Roots

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a quadratic equation  **ax2 + bx + c = 0**, find its roots. If the equation has real roots, then return floor value of each root in decreasing order, If the roots are imaginary return  **-1**, the driver code will print  **Imaginary**.

 **Examples:** 

```
Input: a = 1, b = -2, c = 1
Output: [1, 1]
Explanation: Roots of equation x2-2x+1 are 1 and 1.
```

```
Input: a = 1, b = -7, c = 12
Output: [4, 3]
Explanation: Roots of equation x2 - 7x + 12 are 4 and 3.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T13:37:46.620Z  

```java

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> roots = new ArrayList<>();

        // Calculate the discriminant
        double discriminant = (double) b * b - 4.0 * a * c;

        // If discriminant is negative, roots are imaginary
        if (discriminant < 0) {
            roots.add(-1);
            return roots;
        }

        // Calculate both real roots
        double root1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);

        // Take the floor value of both roots
        int r1 = (int) Math.floor(root1);
        int r2 = (int) Math.floor(root2);

        // Return in decreasing order
        roots.add(Math.max(r1, r2));
        roots.add(Math.min(r1, r2));

        return roots;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/quadratic-equation-roots/1)