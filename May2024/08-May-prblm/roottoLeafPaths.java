import java.util.jar.Attributes.Name;

package 08-May-prblm;

public class roottoLeafPaths {


    Name Of The Problem :- Root to Leaf Paths

    POTD :- 08-May-2024

    Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 
10 20 40 
10 20 60 
10 30 
Your Task:
Your task is to complete the function Paths() which takes the root node as an argument and returns all the possible paths. (All the paths are printed in new lines by the driver's code.)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1<=n<=104

*****************************************************************************************************************************************************


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    static void help(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            temp.add(root.data);
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.addAll(temp);
            ans.add(temp2);
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.data);
        help(root.left,ans,temp);
        help(root.right,ans,temp);
        temp.remove(temp.size()-1);
    }
   public static ArrayList<ArrayList<Integer>> Paths(Node root) {
       // code here
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       ArrayList<Integer> temp = new ArrayList<>();
       help(root,ans,temp);
       return ans;
   }
}
       

    
}
