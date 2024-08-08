package 08-Aug-prblm;


public class sumTree {

    Name Of The Problem :- Sum Tree

    POTD :- 08-August-2024

    Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.

A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

Examples :

Input:
    3
  /   \    
 1     2
Output: true
Explanation: The sum of left subtree and right subtree is 1 + 2 = 3, which is the value of the root node. Therefore,the given binary tree is a sum tree.
Input:
          10
        /    \
      20      30
    /   \ 
   10    10
Output: false
Explanation: The given tree is not a sum tree. For the root node, sum of elements in left subtree is 40 and sum of elements in right subtree is 30. Root element = 10 which is not equal to 30+40.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(Height of the Tree)

Constraints:
2 ≤ number of nodes ≤ 105
1 ≤ node value ≤ 105

*****************************************************************************************************************************************************
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public int solve(Node root, boolean[] ans) {
       if (root == null) {
           return 0;
       }
       if (root.left == null && root.right == null) {
           return root.data;
       }
       int leftAns = solve(root.left, ans);
       int rightAns = solve(root.right, ans);
       if (leftAns + rightAns != root.data) {
           ans[0] = false;
       }
       return leftAns + rightAns + root.data;
   }
   boolean isSumTree(Node root) {
       // Your code here
       boolean[] ans = {true};
       solve(root, ans);
       return ans[0];
   }
}


    
}
