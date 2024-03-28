package 28-march-prblm;

public class CityWiththeSmallestNumbeofNeighborataThresholdDistance {



    Name Of The Problem :- City With the Smallest Number of Neighbors at a Threshold Distance


    POTD :- 28-march-2024

    There are n cities labeled from 0 to n-1 with m edges connecting them. Given the array edges where edges[i] = [fromi , toi ,weighti]  represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold. You need to find out a city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance. If there are multiple such cities, our answer will be the city with the greatest label.

Note: The distance of a path connecting cities i and j is equal to the sum of the edge's weights along that path.

Example 1:

Input:
n = 4, m = 4
edges = [[0, 1, 3],
         [1, 2, 1], 
         [1, 3, 4],  
         [2, 3, 1]]
distanceThreshold = 4
Output:
3
Explaination:

The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
Example 2:

Input: 
n = 5, m = 6
edges = [[0, 1, 2],
         [0, 4, 8],
         [1, 2, 3], 
         [1, 4, 2], 
         [2, 3, 1],
         [3, 4, 1]]
distanceThreshold = 2.
Output:
0
Explaination:

The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4] 
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findCity( ) which takes a number of nodes n, total number of edges m and vector of edges and distanceThreshold. and return the city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance. If there are multiple such cities, return the city with the greatest label.

Expected Time Complexity: O(n2 + length(edges)*nlog(n) )
Expected Auxiliary Space:  O(n3)

Constraints:
1  ≤  n ≤  100
1 <= m <= n*(n-1)/2
length(edges[i]) == 3
0 <= fromi < toi < n
1 <= weighti distanceThreshold <= 104
All pairs (fromi, toi) are distinct

-----------------------------------------------------------------------------------------------------------------------------------------------------

class Node {
    int v, w;
    
    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
class Solution {
  int findCity(int n, int m, int[][] edges,int distanceThreshold)
  {
      //code here
       List<List<Node>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }
    
    // Constructing adjacency list
    for (int[] edge : edges) {
        adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        adj.get(edge[1]).add(new Node(edge[0], edge[2])); // Considering bidirectional edges
    }
    
    int minCities = Integer.MAX_VALUE;
    int result = -1;
    
    //running dijkstras for reach city
    for (int i = 0; i < n; i++) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dijkstra(adj, i, dis);
        
        int reachableCities = 0;
        for (int j = 0; j < n; j++) {
            if (dis[j] <= distanceThreshold) {
                reachableCities++;
            }
        }
        
       //tracking min
        if (reachableCities <= minCities) {
            minCities = reachableCities;
            result = i;
        }
    }
    
    return result;
  }
     // Dijkstra's Algorithm
void dijkstra(List<List<Node>> adj, int start, int[] dis) {
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
    dis[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
        Node currNode = pq.poll();
        for (Node nei : adj.get(currNode.v)) {
            if (dis[nei.v] > dis[currNode.v] + nei.w) {
                dis[nei.v] = dis[currNode.v] + nei.w;
                pq.add(new Node(nei.v, dis[nei.v]));
            }
        }
    }
}
}



    
}
