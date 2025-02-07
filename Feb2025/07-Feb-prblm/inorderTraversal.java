package 07-Feb-prblm;

public class inorderTraversal {


    Name Of The problem :- Inorder Traversal


    POTD :- 07-February-2025

    Given a Binary Tree, your task is to return its In-Order Traversal.

An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

Examples:

Input: root[] = [1, 2, 3, 4, 5] 
      
Output: [4, 2, 5, 1, 3]
Explanation: The in-order traversal of the given binary tree is [4, 2, 5, 1, 3].
Input: root[] = [8, 1, 5, N, 7, 10, 6, N, 10, 6]
      
Output: [1, 7, 10, 8, 6, 10, 5, 6]
Explanation: The in-order traversal of the given binary tree is [1, 7, 10, 8, 6, 10, 5, 6].
Constraints:
1 <= number of nodes <= 105
0 <= node->data <= 105

*****************************************************************************************************************************************************


/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        
          ArrayList<Integer> ans = new ArrayList();
         solve(root, ans);
         return ans;
    }
    void solve(Node root, ArrayList<Integer> ans) {
        if(root == null)
            return;
        solve(root.left, ans);
        ans.add(root.data);
        solve(root.right, ans);
    }
}
    
}
