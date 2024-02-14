package 14-feb-prblm;

public class findAllCriticalConnectionInTheGraph {


    Name Of The Problem :- Find all Critical Connections in the Graph

    POTD :- 14-feb-2024


    A critical connection refers to an edge that, upon removal, will make it impossible for certain nodes to reach each other through any path. You are given an undirected connected graph with v vertices and e edges and each vertex distinct and ranges from 0 to v-1, and you have to find all critical connections in the graph. It is ensured that there is at least one such edge present.

Note: The answers may be presented in various potential orders. Each edge should be displayed in sorted order. For instance, if there's an edge between node 1 and node 2, it should be stored as (1,2) rather than (2,1). Additionally, it is expected that you store the edges in sorted order.

Example 1:

Input:

Output:
0 1
0 2
Explanation: 
On removing edge (0, 1), you will not be able to
reach node 0 and 2 from node 1. Also, on removing
edge (0, 2), you will not be able to reach node 0
and 1 from node 2.
Example 2:

Input:

Output:
2 3
Explanation:
The edge between nodes 2 and 3 is the only
Critical connection in the given graph.
Your task:
You dont need to read input or print anything. Your task is to complete the function criticalConnections() which takes the integer v denoting the number of vertices and an adjacency list adj as input parameters and returns  a list of lists containing the Critical connections in the sorted order.

Expected Time Complexity: O(v + e)
Expected Auxiliary Space: O(v)

Constraints:
1 ≤ v, e ≤ 104



-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution
{
    
    
static int timer=1;
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> ans,int lowtime[],int parent){
        lowtime[node]=timer;
        int parentTime=timer;
        timer++;
        for(int x:adj.get(node)){
            if(x==parent)continue;
            else if(lowtime[x]==0){
                dfs(x,adj,ans,lowtime,node);
            }
            lowtime[node]=Math.min(lowtime[node],lowtime[x]);
            if(parentTime<lowtime[x]){
                ArrayList<Integer> temp = new ArrayList<>();
                if(node<x){
                    temp.add(node);
                    temp.add(x);
                }
                else{
                    temp.add(x);
                    temp.add(node);
                }
                ans.add(temp);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	    int lowtime[] = new int[v];
	    Arrays.fill(lowtime,0);
	    timer=1;
	    dfs(0,adj,ans,lowtime,-1);
	    Collections.sort(ans,new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                if(a.get(0)-b.get(0)==0)return a.get(1)-b.get(1);
                return a.get(0)-b.get(0);
            }
        });
	    return ans;
    }
    
}
    
}
