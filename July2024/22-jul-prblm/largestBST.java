package 22-jul-prblm;

public class LargestBST {


    name Of The Problem :- Largest BST

    POTD :- 22-July-2024

    Given a binary tree. Find the size of its largest subtree which is a Binary Search Tree.
Note: Here Size equals the number of nodes in the subtree.

Examples :

Input:   1
        /  \
        4   4              
       / \ 
      6   8
Output: 1 
Explanation: There's no sub-tree with size greater than 1 which forms a BST. All the leaf Nodes are the BSTs with size equal to 1.

Input:    6
        /   \
      6      2              
       \    / \
        2  1   3
Output: 3
Explanation: The following sub-tree is a BST of size 3:  2
                                                       /   \
                                                      1     3
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106

*****************************************************************************************************************************************************BST

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


class NodeValue{
    int maxVal,minVal,maxSize;
    public NodeValue(int minVal,int maxVal,int maxSize){
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.maxSize = maxSize;
    }
};

class Solution{
    static NodeValue help(Node root){
        if(root==null){
            NodeValue temp = new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
            return temp;
        }
        NodeValue left = help(root.left);
        NodeValue right = help(root.right);
        if(left.maxVal<root.data&&root.data<right.minVal){
            NodeValue temp = new NodeValue(Math.min(root.data,left.minVal),Math.max(root.data,right.maxVal),left.maxSize+
            right.maxSize+1);
            return temp;
        }
        NodeValue temp = new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize));
        return temp;
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return help(root).maxSize;
        
    }
    
}
    
}
