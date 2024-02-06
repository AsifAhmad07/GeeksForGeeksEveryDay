package 06-feb-prblm;

public class nodeAtDistance {


    Name Of The Problem :- Node at distance

    Date :- 06-feb-2024

    Given a binary tree with n nodes and a non-negative integer k, the task is to count the number of special nodes. A node is considered special if there exists at least one leaf in its subtree such that the distance between the node and leaf is exactly k.

Note: Any such node should be counted only once. For example, if a node is at a distance k from 2 or more leaf nodes, then it would add only 1 to our count.

Example 1:

Input:
Binary tree
        1
      /   \
     2     3
   /  \   /  \
  4   5  6    7
          \ 
          8
k = 2
Output: 
2
Explanation: 
There are only two unique nodes that are at a distance of 2 units from the leaf node. (node 3 for leaf with value 8 and node 1 for leaves with values 4, 5 and 7) Note that node 2 isn't considered for leaf with value 8 because it isn't a direct ancestor of node 8.
Example 2:

Input:
Binary tree
          1
         /
        3
       /
      5
    /  \
   7    8
         \
          9
k = 4
Output: 
1
Explanation: 
Only one node is there which is at a distance of 4 units from the leaf node.(node 1 for leaf with value 9) 
Your Task:
You don't have to read input or print anything. Complete the function printKDistantfromLeaf() that takes root node and k as inputs and returns the number of nodes that are at distance k from a leaf node. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 105


-----------------------------------------------------------------------------------------------------------------------------------------------------

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    //Function to return count of nodes at a given distance from leaf nodes.
    HashSet<Node> set;
    int printKDistantfromLeaf(Node root, int k)
    {
        // Write your code here
        set = new HashSet<>();
        dfs(root,k);
        return set.size();
    }
    void dfs(Node root, int k){
        if(root==null) return;
        dfs(root.left, k);
        if(isValid(root,k))
            set.add(root);
        dfs(root.right, k);
        
    }
    boolean isValid(Node root, int k){
        if(root==null) return false;
        if(root.left==null && root.right==null){
            return k==0;
        }
        return isValid(root.left, k-1) || isValid(root.right,k-1);
    }

}

    
}
