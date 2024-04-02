package 02-April-prblm;

public class minimumAbsoluteDifferenceInBST {


    Name Of The Problem :- Minimum Absolute Difference In BST

    POTD :- 02-April-2024

    Given a binary search tree having n (n>1) nodes, the task is to find the minimum absolute difference between any two nodes.

Example 1:

Input:
Input tree

Output:
10
Explanation:
There are no two nodes whose absolute difference is smaller than 10.
Example 2:

Input:
Input tree

Output:
20
Explanation:
There are no two nodes whose absolute difference is smaller than 20.
Your Task:
You don't have to take any input. Just complete the function absolute_diff() , that takes root as input and return minimum absolute difference between any two nodes.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(Height of tree)

Constraints:
2 <= n <= 105
1 <= Node->data <= 109


-----------------------------------------------------------------------------------------------------------------------------------------------------


/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/
class Solution
{
    int prev;
    int ans;
    int absolute_diff(Node root)
    {
        ans = Integer.MAX_VALUE;
         prev=Integer.MAX_VALUE;
         inorder(root);
         
         return ans;
         
    }
     void inorder(Node root ) {
        if (root == null) {
            return;
        }
       
        inorder(root.left);
        
         if(prev!=Integer.MAX_VALUE){
         ans = Math.min( ans, root.data-prev);
        }
        prev=root.data;
        
        inorder(root.right);
    }
}
    
}
