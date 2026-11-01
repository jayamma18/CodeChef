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
