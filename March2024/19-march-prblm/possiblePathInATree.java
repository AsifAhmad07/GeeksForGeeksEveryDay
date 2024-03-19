package 19-march-prblm;

public class possiblePathInATree {


    Name Of The Problem :- Possible Paths in a Tree


    POTD :- 19-march-2024

    Given a weighted tree with n nodes and (n-1) edges. You are given q queries. Each query contains a number x. For each query, find the number of paths in which the maximum edge weight is less than or equal to x.

Note: Path from A to B and B to A are considered to be the same.

Example 1:

Input: 
n = 3
edges {start, end, weight} = {{1, 2, 1}, {2, 3, 4}}
q = 1
queries[] = {3}
Output: 
1
Explanation:
Query 1: Path from 1 to 2
Example 2:

Input: 
n = 7
edges {start, end, weight} = {{1, 2, 3}, {2, 3, 1}, {2, 4, 9}, {3, 6, 7}, {3, 5, 8}, {5, 7, 4}}
q = 3
queries[] = {1, 3, 5}
Output: 
1 3 4
Explanation: 
Query 1: Path from 2 to 3
Query 2: Path from 1 to 2, 1 to 3, and 2 to 3
Query 3: Path from 1 to 2, 1 to 3, 2 to 3, and 5 to 7
Your Task:  
You don't need to read input or print anything. Complete the function maximumWeight()which takes integers n, list of edges where each edge is given by {start,end,weight}, an integer q and a list of q queries as input parameters and returns a list of integers denoting the number of possible paths for each query. 

Expected Time Complexity: O(nlogn + qlogn)
Expected Auxiliary Space: O(n)

Constraints:
2 ≤ n ≤ 104
1 ≤ q ≤ 104
1 ≤ edges[i][0], edges[i][1] ≤ n
edges[i][0] != edges[i][1]
0 ≤ edges[i][2] ≤ 105
0 ≤ queries[i] ≤ 105


-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution { 
    
    int ans;
    int[] parent ; 
     int[] size ;
   ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
       // code here   
       ans = 0;

       parent = new int[n + 1];
       size = new int[n + 1];
       Arrays.fill(size, 1);
       for (int i = 0; i <= n; i++) {
           parent[i] = i;
       }
        ArrayList<Integer> res = new ArrayList<>();
       Map<Integer, Integer> mp = new TreeMap<>(); // asc sorted

       // Sorting the edges based on their weights in ascending order to get our work done.
       Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

       for (int i = 0; i < n - 1; i++){

       //  (k,v) - value is the number of path with in which mx wt  <= k
           mp.put(edges[i][2], Union(edges[i][0], edges[i][1]));
       }

       
      for (int query : queries) { //q logn
           int maxWeight = 0;
           for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
               if (entry.getKey() <= query) 
                   maxWeight = entry.getValue();
               else
                   break;
           }
           res.add(maxWeight);
       }
       return res;
   }
   
   int find(int x) {
       if(x==parent[x])
       return x;
       
       return parent[x] = find(parent[x]); // find path compression
   }

   int Union(int a, int b) {
   int rootA = find(a);
   int rootB = find(b);

   //union by rank - bigger rank always become parent to avoud chaining
       if (size[rootA] < size[rootB]) {
             ans += size[rootA] * size[rootB];  // only change
           parent[rootA] = rootB;
           size[rootB] += size[rootA];
           
       } else if (size[rootA] > size[rootB]) {
             ans += size[rootA] * size[rootB];
           parent[rootB] = rootA;
           size[rootA] += size[rootB];
       } else {
               ans += size[rootA] * size[rootB];
           parent[rootB] = rootA;
           size[rootA] += size[rootB];
       }
       
         return ans;
   }
}
    
}
