package 13-May-prblm;

public class numberofGoodComponents {


    Name Of The Problem :- Number of Good Components

    POTD :- 13-May-2024


    Given an undirected graph with v vertices(numbered from 1 to v) and e edges. Find the number of good components in the graph.
A component of the graph is good if and only if the component is fully connected.
Note: A fully connected component is a subgraph of a given graph such that there's an edge between every pair of vertices in the component, the given graph can be a disconnected graph. 

Example 1:

Input: 


e=3 
v=3
edges={{1, 2},{1, 3},{3, 2}}
Output: 
1
Explanation: 
We can see that there is only one component in the graph and in this component there is a edge between any two vertces.
Example 2:

Input:

e=5 
v=7
edges={{1, 2},{7, 2},{3, 5},{3, 4},{4, 5}}
Output: 
2
Explanation: 
We can see that there are 3 components in the graph. For 1-2-7 there is no edge between 1 to 7, so it is not a fully connected component. Rest 2 are individually fully connected component.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findNumberOfGoodComponent(), which takes an integer e and v and edges[][] as input parameters and returns an integer denoting the number of good components.

Expected Time Complexity: O(v+e)
Expected Auxiliary Space: O(depth of the graph)

Constraints:
1 <= edges[i][0], edges[i][1] <= v
1 ≤ v, e ≤ 104
All edges are unique


*****************************************************************************************************************************************************


class Solution {
    static int v_count;
    static int e_count;
     static boolean vis[];
     public static int findNumberOfGoodComponent(int e, int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for (int i = 0; i <= V; i++) {
             adj.add(new ArrayList<>());
         }
         for (int[] edge : edges) {
             adj.get(edge[0]).add(edge[1]);
             adj.get(edge[1]).add(edge[0]); // if the graph is undirected
         }
          vis = new boolean[V+1];
         //dfs for all vertices
         int ans=0;
         for(int i=1; i<=V; i++)
         {
             if(!vis[i])
             {
                 v_count=e_count=0;
                 dfs(adj, i);
             
             if(e_count == (v_count *(v_count-1))) ans++;
             
             }
         }
         return ans;
         
     }
    static void dfs(ArrayList<ArrayList<Integer>> adj, int st)
     {
         vis[st]=true;
         v_count++; e_count += adj.get(st).size();
         //itr for nei
         for(int nei : adj.get(st) )
         {
             if(!vis[nei])
              dfs(adj, nei);
         }
     }
     
 }
    
}
