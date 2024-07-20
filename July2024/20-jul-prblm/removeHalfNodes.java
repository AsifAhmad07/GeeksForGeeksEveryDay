package 20-jul-prblm;

public class removeHalfNodes {


    Name Of The Problem :- Remove Half Nodes


    POTD :- 20-July-2024

    You are given a binary tree and you need to remove all the half nodes (which have only one child). Return the root node of the modified tree after removing all the half-nodes.

Note: The output will be judged by the inorder traversal of the resultant tree, inside the driver code.

Examples:

Input: tree = 5
            /   \
          7     8
        / 
      2
Output: 2 5 8
Explanation: In the above tree, the node 7 has only single child. After removing the node the tree becomes  2<-5->8. Hence, the answer is 2 5 8 & it is in inorder traversal.
Input:  tree = 2   
              / \   
            7   5 
Output: 7 2 5
Explanation: Here there are no nodes which has only one child. So the tree remains same.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the binary tree)

Constraints:
1<=number of nodes<=104

*****************************************************************************************************************************************************


    /*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

*/

class Solution {
    // Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        // Code Here
          if(root==null)return null;
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        if(root.left==null && root.right!=null)return root.right;
        if(root.left!=null && root.right==null)return root.left;
        return root;
    }
}

}
