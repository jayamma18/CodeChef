# FREQUENCYSOR - Rating 1050

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Chef and Character Frequency Sort

Chef is experimenting with strings. He wants to rearrange all the characters of a given string  **$S$**  in decreasing order of their frequency.

If two characters have the same frequency, Chef sorts them in  **lexicographical (ASCII) order**.

Help Chef by printing the final rearranged string.

### Function Declaration
- Function Name: $sortByFrequency$
- Parameters: $s$ ($string$) A string consisting of uppercase and lowercase English letters and digits.
- Return Value: Returns a $string$ representing the rearranged string after sorting by the given rules.
### Input Format
- The first and only line contains a string S.
- The string consists of uppercase and lowercase English letters and digits.
### Output Format

Print the rearranged string after sorting by the given rules.

### Constraints
- $1 \le |S| \le 5 \times 10^{5}$
### Sample 1:
Input
Output

```
CookBook

```

```
ooookkBC

```

### Explanation:

 **Input:**  `CookBook`

The character frequencies are:

- o $\rightarrow$ 4
- B $\rightarrow$ 1
- C $\rightarrow$ 1
- k $\rightarrow$ 1

Chef first places characters in  **decreasing frequency**  order, so `o` comes first as `oooo`. The remaining characters all have the same frequency  **1**, so they are arranged in  **ASCII (lexicographical) order** :

`k < B < C`

So the final rearranged string is:

```
ooookkBC

```

### Sample 2:
Input
Output

```
aabbbcddd

```

```
bbbdddaac

```

### Explanation:

 **Input:**  `aabbbcddd`

The character frequencies are:

- b $\rightarrow$ 3
- d $\rightarrow$ 3
- a $\rightarrow$ 2
- c $\rightarrow$ 1

Characters with frequency  **3**  are `b` and `d`, and since `b < d`, they appear as: `bbbddd`

Then `a` appears twice: `aa`

Finally, `c` appears once: `c`

So the final rearranged string is:

```
bbbdddaac

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T10:24:43.604Z  

```java
public static String sortByFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Character> chars = new ArrayList<>(freq.keySet());
        Collections.sort(chars, (a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa != fb) {
                return fb - fa; // higher frequency first
            }
            return a - b; // lexicographical order if equal frequency
        });

        // Build result string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

```

---

[View on CodeChef](https://www.codechef.com/problems/FREQUENCYSOR)