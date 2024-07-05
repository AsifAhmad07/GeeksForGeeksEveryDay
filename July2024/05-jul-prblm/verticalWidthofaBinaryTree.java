package 05-jul-prblm;

public class verticalWidthofaBinaryTree {


    Name Of The Problem :- Vertical Width of a Binary Tree

    POTD :- 05-July-2024

    Given a Binary Tree. You need to find and return the vertical width of the tree.

Examples :

Input:
         1
       /    \
      2      3
     / \    /  \
    4   5  6   7
            \   \
             8   9
Output: 6
Explanation: The width of a binary tree is
the number of vertical paths in that tree.



The above tree contains 6 vertical lines.
Input:
     1
    /  \
   2    3
Output: 3
Explanation: The above tree has 3 vertical lines, hence the answer is 3.
Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(height of the tree).

Constraints:
0 <= number of nodes <= 104

*****************************************************************************************************************************************************of
class Solution {
    // Function to find the vertical width of a Binary Tree.
     static int mn=0,mx=0;
    void help(Node root,int pos){
        if(root==null)return;
        mn=Math.min(mn,pos);
        mx=Math.max(mx,pos);
        help(root.left,pos-1);
        help(root.right,pos+1);
    }
    public int verticalWidth(Node root) {
        // code here.
          if(root==null)return 0;
        mn=0;
        mx=0;
        help(root,0);
        return mx+Math.abs(mn)+1;
    }
}
    
}
