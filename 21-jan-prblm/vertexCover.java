package 21-jan-prblm;

public class vertexCover {

    /*
     * Name Of The Problem :-Vertex Cover
 
     * POTD :- 21-jan-2024
     * 
     * Vertex cover of an undirected graph is a list of vertices such that every vertex not in the vertex cover shares their every edge with the vertices in the vertex cover. In other words, for every edge in the graph, atleast one of the endpoints of the graph should belong to the vertex cover. You will be given an undirected graph G, and your task is to determine the smallest possible size of a vertex cover.

Example 1:

Input:
N=5
M=6
edges[][]={{1,2}
           {4, 1},
           {2, 4},
           {3, 4},
           {5, 2},
           {1, 3}}
Output:
3
Explanation:
{2, 3, 4} forms a vertex cover
with the smallest size.
Example 2:

Input:
N=2
M=1
edges[][]={{1,2}} 
Output: 
1 
Explanation: 
Include either node 1 or node 2
in the vertex cover.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function vertexCover() which takes the edge list and an integer n for the number of nodes of the graph as input parameters and returns the size of the smallest possible vertex cover.

Expected Time Complexity: O(M*N2log(N))
Expected Auxiliary Space: O(N2)

 Constraints:
1 <= N <= 16
1 <= M <= N*(N-1)/2
1 <= edges[i][0], edges[i][1] <= N
     */

class Solution {
    private static boolean checkCover(int n, int k, int m, ArrayList<ArrayList<Integer>> adj){
        int set = (1 << k) - 1;
        int limit = (1 << n);
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            visited.add(new ArrayList<Boolean>(n + 1));
            for (int j = 0; j < n + 1; j++) {
                visited.get(i).add(false);
            }
        }
        while (set < limit) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    visited.get(i).set(j, false);
                }
            }
            int cnt = 0;
            for (int j = 1, v = 1; j < limit; j = j << 1, v++) {
                if ( (set & j) != 0 ) {
                    for (int l = 1; l <= n; l++) {
                        if (adj.get(v).get(l) == 1 && !visited.get(v).get(l)) {
                            visited.get(v).set(l, true);
                            visited.get(l).set(v, true);
                            cnt++;
                        }
                    }
                }
            }
            if (cnt == m) {
                return true;
            }
            int c = set & -set;
            int r = set + c;
            set = (((r ^ set) >> 2) / c) | r;
        }
        return false;
    }
    private static int vertexCoverHelper(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        int low = 1, high = n;
        while (high > low) {
            int mid = (low + high) >> 1;
            if (checkCover(n, mid, m, adj) == false) {
                low = mid + 1;
            } 
            else {
                high = mid;
            }
        }
        return low;
    }
    public static int vertexCover(int n, int m, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n + 1);
        for(int i = 0; i < n + 1; i++){
            adj.add(new ArrayList<Integer>(n + 1));
            for(int j = 0; j < n + 1; j++){
                adj.get(i).add(0);
            }
        }
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).set(edges[i][1], 1);
            adj.get(edges[i][1]).set(edges[i][0], 1);
        }
        return vertexCoverHelper(adj, n, m);
    }
}   
    
}
