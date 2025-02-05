package 05-Feb-prblm;

public class mirrorTree {


    Name Of The problem :- Mirror Tree


    POTD :- 05-February-2025

    Given a binary tree, convert the binary tree to its Mirror tree.

Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.     

Examples:

Input: root[] = [1, 2, 3, N, N, 4]
Output: [1, 3, 2, N, 4]
Explanation: 

In the inverted tree, every non-leaf node has its left and right child interchanged.
Input: root[] = [1, 2, 3, 4, 5]
Output: [1, 3, 2, N, N, 5, 4]
Explanation:

In the inverted tree, every non-leaf node has its left and right child interchanged.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105


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
} */

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        
        solve(node);
    }
    Node solve(Node node){
        if(node == null){
            return null;
        }
        Node mirroredLeft = solve(node.left);
        Node mirroredRight = solve(node.right);
        node.left = mirroredRight;
        node.right = mirroredLeft;
        return node;
    }
}
    
}
