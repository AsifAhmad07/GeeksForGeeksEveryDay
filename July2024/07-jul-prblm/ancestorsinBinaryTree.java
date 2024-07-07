package 07-jul-prblm;

public class ancestorsinBinaryTree {

    Name Of The Problem :- Ancestors in Binary Tree

    POTD :- 07-July-2024


    Given a Binary Tree and an integer target. Find all the ancestors of the given target.

Note:

The ancestor of node x is node y, which is at the upper level of node x, and x is directly connected with node y. Consider multiple levels of ancestors to solve this problem.
In case there are no ancestors available, return an empty list.
Examples:

Input:
         1
       /   \
      2     3
    /  \    /  \
   4   5  6   8
  /
 7
target = 7
Output: [4 2 1]
Explanation: The given target is 7, if we go above the level of node 7, then we find 4, 2 and 1. Hence the ancestors of node 7 are 4 2 and 1
Input:
        1
      /   \
     2     3
target = 1
Output: [ ]
Explanation: Since 1 is the root node, there would be no ancestors. Hence we return an empty list.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ no. of nodes ≤ 103
1 ≤ data of node ≤ 104

*****************************************************************************************************************************************************


/*class Node of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {
    ArrayList<Integer> ans;
   void help(Node root,int target,ArrayList<Integer> temp){
       if(root==null)return;
       if(root.data==target){
           ans.addAll(temp);
           return;
       }
       temp.add(root.data);
       help(root.left,target,temp);
       help(root.right,target,temp);
       temp.remove(temp.size()-1);
   }

   public ArrayList<Integer> Ancestors(Node root, int target) {
       // add your code here
        ans = new ArrayList<>();
       ArrayList<Integer> temp = new ArrayList<>();
       help(root,target,temp);
       Collections.reverse(ans);
       return ans;
   }
}
    
}
