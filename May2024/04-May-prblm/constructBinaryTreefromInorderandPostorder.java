package 04-May-prblm;

public class constructBinaryTreefromInorderandPostorder {



    Name Of The Problem :- Construct Binary Tree from Inorder and Postorder

    POTD :- 04-May-2024


    Given inorder and postorder traversals of a binary tree(having n nodes) in the arrays in[] and post[] respectively. The task is to construct a binary tree from these traversals.

Driver code will print the preorder traversal of the constructed tree.

Example 1:

Input:
n = 8
in[] = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1}
Output: 
1 2 4 8 5 3 6 7
Explanation: 
For the given postorder and inorder traversal of tree the  resultant binary tree will be
          1
       /      \
     2        3
   /  \      /  \
  4   5    6   7
   \
    8
Example 2:

Input:
n = 5
in[] = {9, 5, 2, 3, 4}
post[] = {5, 9, 3, 4, 2}
Output: 
2 9 5 4 3
Explanation:  
The  resultant binary tree will be
           2
        /     \
       9      4
        \     /
         5   3
Your Task:
You do not need to read input or print anything. Complete the function buildTree() which takes the inorder, postorder traversals and the number of nodes in the tree as input parameters and returns the root node of the newly constructed Binary Tree.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 103
1 <= in[i], post[i] <= 106

*****************************************************************************************************************************************************Auxiliary


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    
        int postIdx;

    Node buildTree(int in[], int post[], int n) {
        // Your code here
        postIdx =n-1;
        return dfs(in, post, 0, n-1);
        
    }
    Node dfs(int in[], int post[], int is, int ie){
        if(is>ie) return null;
        
        Node root = new Node(post[postIdx--]);
        
       int inIdx = is; //O(n)
        for(int i=is; i<=ie; i++){
            if(in[i]==root.data){
                inIdx=i; break;
            }
        }
        //rec
      
        root.right = dfs(in, post, inIdx+1, ie);
        root.left =  dfs(in, post, is, inIdx-1);
        return root;
    }
}
    
}
