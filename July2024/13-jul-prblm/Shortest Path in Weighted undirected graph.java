package 13-jul-prblm;

public class Shortest Path in Weighted undirected graph {


    Name Of The problem :- Shortest Path in Weighted undirected graph


    POTD :- 13-July-2024

    You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges along with their weights. Find the shortest path between the vertex 1 and the vertex n,  if there exists a path, and return a list of integers whose first element is the weight of the path, and the rest consist of the nodes on that path. If no path exists, then return a list containing a single element -1.

The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is the weight of that edge.

Note: The driver code here will first check if the weight of the path returned is equal to the sum of the weights along the nodes on that path, if equal it will output the weight of the path, else -2. In case the list contains only a single element (-1) it will simply output -1. 

Examples :

Input: n = 5, m= 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
Output: 5
Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5. 
Input: n = 2, m= 1, edges = [[1, 2, 2]]
Output: 2
Explanation: Shortest path from 1 to 2 is by the path 1 2 whose weight is 2. 
Input: n = 2, m= 0, edges = [ ]
Output: -1
Explanation: Since there are no edges, so no answer is possible.
Expected Time Complexity: O(m* log(n))
Expected Space Complexity: O(n+m)

Constraint:
2 <= n <= 106
0 <= m <= 106
1 <= a, b <= n
1 <= w <= 105

*****************************************************************************************************************************************************

class Node {
    int v;
    int w;
    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
class Solution {
    int[] dis;
    int[] parent;
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
          List<List<Node>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] arr : edges) {
            adj.get(arr[0]).add(new Node(arr[1], arr[2]));
            adj.get(arr[1]).add(new Node(arr[0], arr[2])); // For undirected graph
        }

        dis = new int[n + 1];
       
        parent = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Run Dijkstra's algorithm
        dijkstra(adj, 1);
         /*for(int i=0; i<=n; i++){
            System.out.print(i+ " "+ dis[i]);
            System.out.println();
        }*/
        // If no path to node n, return [-1]
        if (dis[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        // Reconstruct the path from 1 to n
        List<Integer> path = new ArrayList<>();
        for (int at = n; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        // Create the result list with the weight and the path
        List<Integer> result = new ArrayList<>();
        result.add(dis[n]);
        result.addAll(path);

        return result;
    }
    
     void dijkstra(List<List<Node>> adj, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        
        dis[start] = 0;
        pq.add(new Node(start, 0)); // Start node and its distance

        while (!pq.isEmpty()) {
            Node curr_node = pq.poll();
            for (Node nei : adj.get(curr_node.v)) {
                // u -> v: if (d[v] > d[u] + w[u, v]) then d[v] = d[u] + w[u, v]
                if (dis[nei.v] > dis[curr_node.v] + nei.w) {
                    dis[nei.v] = dis[curr_node.v] + nei.w;
                    parent[nei.v] = curr_node.v; // Track the path
                    pq.add(new Node(nei.v, dis[nei.v]));
                }
            }
        }
    }
}
    
}
