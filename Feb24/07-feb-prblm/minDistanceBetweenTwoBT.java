package 07-feb-prblm;

public class minDistanceBetweenTwoBT {


    Name Of The Problem :- Min distance between two given nodes of a Binary Tree

    POTD :- 07-feb-2024



    Given a binary tree with n nodes and two node values, a and b, your task is to find the minimum distance between them. The given two nodes are guaranteed to be in the binary tree and all node values are unique.

Example 1:

Input:
        1
      /  \
     2    3
a = 2, b = 3
Output: 
2
Explanation: 
We need the distance between 2 and 3. Being at node 2, we need to take two steps ahead in order to reach node 3. The path followed will be: 2 -> 1 -> 3. Hence, the result is 2. 
Example 2:

Input:
        11
      /   \
     22  33
    /  \  /  \
  44 55 66 77
a = 77, b = 22
Output: 
3
Explanation: 
We need the distance between 77 and 22. Being at node 77, we need to take three steps ahead in order to reach node 22. The path followed will be: 77 -> 33 -> 11 -> 22. Hence, the result is 3.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findDist() which takes the root node of the tree and the two node values a and b as input parameters and returns the minimum distance between the nodes represented by the two given node values.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
2 <= n <= 105
0 <= Data of a node <= 109


-----------------------------------------------------------------------------------------------------------------------------------------------------



// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root  */
class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        
         Node LCA = lca(root, a, b);
        return findLevel(LCA, a) + findLevel(LCA, b);
        // return findLevel(LCA, a,0) + findLevel(LCA, b,0); //for dfs
        
    }
    	Node lca(Node root, int n1,int n2){
		// Your code here
		if(root==null)
		return null;
		
		if(root.data==n1 || root.data== n2)
		return root;
		
		Node left = lca(root.left, n1,n2);
		Node right = lca(root.right, n1,n2);
		
		
		if(left!=null && right!=null)
		return root;
		
		if(left!=null && right==null)
		return left;
		
		else return right;
	}
	//bfs
	int findLevel(Node root, int a) {
    if (root == null)
        return -1;

    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int level = 0;

    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Node curr = q.poll();
            
            if (curr.data == a)
                return level;
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        level++;
    }

    return -1;
	
    }
}
    
}
