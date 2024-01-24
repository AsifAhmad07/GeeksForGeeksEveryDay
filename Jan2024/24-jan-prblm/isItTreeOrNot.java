import java.util.ArrayList;

public class isItTreeOrNot {

    /*
     * Name Of The Problem :- Check if a given graph is tree or not
     * 
     * POTD :- 24-jan-2024
     * You are given an undirected graph of N nodes and M edges. Return 1 if the graph is a tree, else return 0.

Note: The input graph can have self-loops and multiple edges.

Example 1:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [1, 3]]
Output: 
1
Explanation: 
Every node is reachable and the graph has no loops, so it is a tree
Example 2:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [2, 0]]
Output: 
0
Explanation: 
3 is not connected to any node and there is a loop 0->1->2->0, so it is not a tree.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isTree() which takes the integer N (the number nodes in the input graph) and the edges representing the graph as input parameters and returns 1 if the input graph is a tree, else 0.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 2*105
0 <= M <= 2*105

Topic Tags


     */

//User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        if(n-m!=1) return false;
        ArrayList<Integer>[] adj = new ArrayList[n];
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            adj[edges.get(i).get(0)].add(edges.get(i).get(1));
            adj[edges.get(i).get(1)].add(edges.get(i).get(0));
        }
        
        dfs(0,adj,arr);
        
        for(int k : arr) if(k==0) return false;
        
        return true;
        
    }
    
    void dfs(int n, ArrayList<Integer>[] adj, int arr[]){
        arr[n] = 1;
        for(int x : adj[n]) if(arr[x]==0) dfs(x,adj,arr);
    }
}
}