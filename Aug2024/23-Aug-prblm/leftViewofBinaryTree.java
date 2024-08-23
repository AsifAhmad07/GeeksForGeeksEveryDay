package 23-Aug-prblm;

public class leftViewofBinaryTree {


    Name Of The Problem :- Left View of Binary Tree


    POTD :- 23-August-2024


    Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument. If no left view is possible, return an empty tree.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Examples :

Input:
   1
 /  \
3    2
Output: 1 3

Input:

Output: 10 20 40
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
0 <= Data of a node <= 105


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
}*/
class Tree
{
     void help(Node root,ArrayList<Integer> ans,int level,Map<Integer,Integer> mm){
        if(root==null)return;
        if(mm.get(level)==null){
            ans.add(root.data);
            mm.put(level,1);
        }
        level++;
        help(root.left,ans,level,mm);
        help(root.right,ans,level,mm);
    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
       ArrayList<Integer> ans = new ArrayList<>();
       Map<Integer,Integer> mm = new HashMap<>();
       help(root,ans,0,mm);
       return ans;
    }
}
    
}
