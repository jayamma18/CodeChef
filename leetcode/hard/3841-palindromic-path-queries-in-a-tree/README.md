# Palindromic Path Queries in a Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an undirected tree with `n` nodes labeled 0 to `n - 1`. This is represented by a 2D array `edges` of length `n - 1`, where `edges[i] = [ui, vi]` indicates an undirected edge between nodes `ui` and `vi`.

You are also given a string `s` of length `n` consisting of lowercase English letters, where `s[i]` represents the character assigned to node `i`.

You are also given a string array `queries`, where each `queries[i]` is either:

- "update ui c": Change the character at node ui to c. Formally, update s[ui] = c.
- "query ui vi": Determine whether the string formed by the characters on the unique path from ui to vi (inclusive) can be rearranged into a palindrome.

Return a boolean array `answer`, where `answer[j]` is `true` if the `jth` query of type `"query ui vi"​​​​​​​` can be rearranged into a  **palindrome**, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  n = 3, edges = [[0,1],[1,2]], s = "aac", queries = ["query 0 2","update 1 b","query 0 2"]

 **Output:**  [true,false]

 **Explanation:** 

- "query 0 2": Path 0 → 1 → 2 gives "aac", which can be rearranged to form "aca", a palindrome. Thus, answer[0] = true.
- "update 1 b": Update node 1 to 'b', now s = "abc".
- "query 0 2": Path characters are "abc", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.

Thus, `answer = [true, false]`.

 **Example 2:** 

 **Input:**  n = 4, edges = [[0,1],[0,2],[0,3]], s = "abca", queries = ["query 1 2","update 0 b","query 2 3","update 3 a","query 1 3"]

 **Output:**  [false,false,true]

 **Explanation:** 

- "query 1 2": Path 1 → 0 → 2 gives "bac", which cannot be rearranged to form a palindrome. Thus, answer[0] = false.
- "update 0 b": Update node 0 to 'b', now s = "bbca".
- "query 2 3": Path 2 → 0 → 3 gives "cba", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.
- "update 3 a": Update node 3 to 'a', s = "bbca".
- "query 1 3": Path 1 → 0 → 3 gives "bba", which can be rearranged to form "bab", a palindrome. Thus, answer[2] = true.

Thus, `answer = [false, false, true]`.

 

 **Constraints:** 

- 1 <= n == s.length <= 5 * 104
- edges.length == n - 1
- edges[i] = [ui, vi]
- 0 <= ui, vi <= n - 1
- s consists of lowercase English letters.
- The input is generated such that edges represents a valid tree.
- 1 <= queries.length <= 5 * 104​​​​​​​queries[i] = "update ui c" or queries[i] = "query ui vi" 0 <= ui, vi <= n - 1 c is a lowercase English letter.

## Solution

**Language:** Java  
**Runtime:** 107 ms (beats 64.07%)  
**Memory:** 172.2 MB (beats 75.65%)  
**Submitted:** 2026-11-01T11:57:35.420Z  

```java
import java.util.*;

class Solution {
    private int[] head, to, next;
    private int edgeCount;
    
    // HLD Variables
    private int[] parent, depth, heavy, headHLD, pos;
    private int curPos;
    
    // Fenwick Tree (BIT) supporting XOR
    private int[] bit;
    private int[] nodeMask;
    private int treeSize;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        // Step 1: Initialize adjacency list for the tree
        head = new int[n];
        Arrays.fill(head, -1);
        to = new int[2 * n];
        next = new int[2 * n];
        edgeCount = 0;

        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }

        // Step 2: HLD Arrays Setup
        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        headHLD = new int[n];
        pos = new int[n];
        Arrays.fill(heavy, -1);
        curPos = 1;

        // Perform two DFS passes for HLD
        dfs1(0, -1, 0);
        dfs2(0, 0);

        // Step 3: Initialize Fenwick Tree with initial bitmasks
        treeSize = n;
        bit = new int[treeSize + 1];
        nodeMask = new int[n];

        for (int i = 0; i < n; i++) {
            int mask = 1 << (s.charAt(i) - 'a');
            nodeMask[i] = mask;
            updateBIT(pos[i], mask);
        }

        List<Boolean> answers = new ArrayList<>();

        // Step 4: Process Queries
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                
                int oldMask = nodeMask[u];
                int newMask = 1 << (c - 'a');
                
                // Update node tracking and toggle bits in the Fenwick tree
                nodeMask[u] = newMask;
                updateBIT(pos[u], oldMask ^ newMask);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                
                int pathXor = queryPath(u, v);
                
                // A path can form a palindrome if it has at most 1 bit set to 1
                boolean isPalindrome = (pathXor & (pathXor - 1)) == 0;
                answers.add(isPalindrome);
            }
        }

        return answers;
    }

    private void addEdge(int u, int v) {
        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    // First DFS pass: Compute depth, parent, and find heavy child
    private int dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        int size = 1;
        int maxChildSize = 0;

        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];
            if (v != p) {
                int childSize = dfs1(v, u, d + 1);
                size += childSize;
                if (childSize > maxChildSize) {
                    maxChildSize = childSize;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    // Second DFS pass: Decompose into chains and map to segment array positions
    private void dfs2(int u, int h) {
        headHLD[u] = h;
        pos[u] = curPos++;

        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }

        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    // Fenwick Tree point XOR update
    private void updateBIT(int idx, int val) {
        for (; idx <= treeSize; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    // Fenwick Tree prefix XOR query
    private int queryBIT(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum ^= bit[idx];
        }
        return sum;
    }

    private int queryRange(int l, int r) {
        return queryBIT(r) ^ queryBIT(l - 1);
    }

    // Query path XOR sum between node u and v using HLD chains
    private int queryPath(int u, int v) {
        int res = 0;
        while (headHLD[u] != headHLD[v]) {
            if (depth[headHLD[u]] > depth[headHLD[v]]) {
                res ^= queryRange(pos[headHLD[u]], pos[u]);
                u = parent[headHLD[u]];
            } else {
                res ^= queryRange(pos[headHLD[v]], pos[v]);
                v = parent[headHLD[v]];
            }
        }
        if (depth[u] > depth[v]) {
            res ^= queryRange(pos[v], pos[u]);
        } else {
            res ^= queryRange(pos[u], pos[v]);
        }
        return res;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/palindromic-path-queries-in-a-tree/)