package 13-feb-prblm;

public class cloneAnUndirectedGraph {


    Name Of The Problem :- Clone an Undirected Graph


    Date :- 13-feb-2024


    Given a connected undirected graph with n nodes and m edges, with each node having a distinct label from 0 to n-1, create a clone of the graph. Each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.

Note: If the user returns a correct copy of the given graph, then the system will print 1; in the case when an incorrect copy is generated or when the user returns the original node, the system will print 0.

For Example :    

class Node {
    val: integer
    neighbors: List[Node]
}
Example 1:

Input:
adjList = 
{
    {1, 3},
    {0, 2},
    {1, 3},
    {0, 2}
}
Output: 1
Explanation:
1 is the output that the driver code will print in case 
you successfully cloned the given graph.
Example 2:

Input:
adjList = 
{
    {1},
    {0}
}
Output: 1
Explanation: 
1 is the output that the driver code will print in case
you successfully cloned the given graph.
Your Task:
You don't need to read input or print anything. Your task is to complete the function cloneGraph( ) which takes a node will always be the first node of the graph as input and returns the copy of the given node as a reference to the cloned graph.

Expected Time Complexity: O(n + m).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n, m <= 104
1 <= Node value <= n


-----------------------------------------------------------------------------------------------------------------------------------------------------



//User function Template for Java


/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution{
    Node cloneGraph(Node node){
        
           if (node == null)
            return null;

        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node copy = new Node(node.val);
        map.put(node.val, copy);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neigh : curr.neighbors) {
                if (!map.containsKey(neigh.val)) {
                    Node copyNeigh = new Node(neigh.val);
                    map.put(neigh.val, copyNeigh);
                    queue.add(neigh);
                }
                map.get(curr.val).neighbors.add(map.get(neigh.val));
            }
        }

        return copy;
        
    }
}
    
}
