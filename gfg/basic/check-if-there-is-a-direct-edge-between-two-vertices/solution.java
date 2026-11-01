import java.util.ArrayList;

class Solution {
    public boolean checkEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // Access the neighbor list of vertex u and check if v is inside it
        return adj.get(u).contains(v);
    }
}
