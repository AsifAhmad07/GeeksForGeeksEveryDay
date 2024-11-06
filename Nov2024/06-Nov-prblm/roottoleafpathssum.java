package 06-Nov-prblm;

public class roottoleafpathssum {



    Name Of The Problem :- Root to leaf paths sum


    POTD :- 06-Novemeber-2024

    Given a binary tree, where every node value is a number. Find the sum of all the numbers that are formed from root to leaf paths. The formation of the numbers would be like 10*parent + current (see the examples for more clarification).

Examples:

Input:      

Output: 13997
Explanation : There are 4 leaves, resulting in leaf path of 632, 6357, 6354, 654 sums to 13997.
Input:    

Output: 2630
Explanation: There are 3 leaves, resulting in leaf path of 1240, 1260, 130 sums to 2630.
Input:    
           1
          /
         2                    
Output: 12
Explanation: There is 1 leaf, resulting in leaf path of 12.
Constraints:
1 ≤ number of nodes ≤ 31
1 ≤ node->data ≤ 100

*****************************************************************************************************************************************************



/*Complete the function below.
Node is as follows:
class Tree
{
      int data;
      Tree left,right;
      Tree(int d){
          data=d;
          left=null;
          right=null;
}
}*/
class Solution {
    
    public static int help(Node root,int num){
      if(root==null)return 0;
      num = num*10+root.data;
      if(root.left==null && root.right==null)return num;
      return help(root.left,num)+help(root.right,num);
  }
  public static int treePathsSum(Node root) {
      // add code here.
      
      return help(root,0);
  }
}
    
}
