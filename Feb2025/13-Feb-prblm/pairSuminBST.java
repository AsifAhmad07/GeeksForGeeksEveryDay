package 13-Feb-prblm;

public class pairSuminBST {


    Name Of The Problem :- Pair Sum in BST

    POTD :- 13-February-2025

    Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
          bst-3
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
Constraints:

1 ≤ Number of Nodes ≤ 105
1 ≤ target ≤ 106

*****************************************************************************************************************************************************

/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    boolean findTarget(Node root, int target) {
        // Write your code here
        if(root == null){
            return false;
        }
        return solve(root, root, target);
    }
    boolean solve(Node root, Node curr, int target){
        if(curr == null){
            return false;
        }
        if(findNode(root, target-curr.data, curr)){
            return true;
        }
        return solve(root, curr.left, target) || solve(root, curr.right, target);
    }
    boolean findNode(Node root, int target, Node curr){
        if(root==null){
            return false;
        }
        if(root.data == target && root != curr) {
            return true;
        }
        if(root.data > target){
            return findNode(root.left, target, curr);
        }
        return findNode(root.right, target, curr);
    }
}
    
}
