package 03-May-prblm;

public class kdistancefromroot {


    Name Of The Problem :- K distance from root

    POTD :- 03-May-2024

    Given a binary tree having n nodes and an integer k. Print all nodes that are at distance k from the root (root is considered at distance 0 from itself). Nodes should be printed from left to right.

Example 1:

Input:
k = 0
      1
    /   \
   3     2
Output: 
1
Explanation: 
1 is the only node which is 0 distance from the root 1.
Example 2:

Input:
k = 3
        1
       /
      2
       \
        1
      /  \
     5    3
Output: 
5 3
Explanation:  
5 and 3 are the nodes which are at distance 3 from the root 3.
Here, returning 3 5 will be incorrect.
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root node and k as parameters and returns the value of the nodes that are at a distance k from the root.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 104
0 <= k <= 30

*****************************************************************************************************************************************************

/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> al;
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          // Your code here
            al = new ArrayList<>();
         dfs(root,k);
         return al;
     }
     void dfs(Node root, int k){
          if(root==null) return ;
          if(k==0) al.add(root.data);
          else{
            dfs(root.left,k-1);
            dfs(root.right, k-1);
          }
     }
}
    
}
