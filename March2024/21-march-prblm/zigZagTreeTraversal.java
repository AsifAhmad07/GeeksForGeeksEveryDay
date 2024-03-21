package 21-march-prblm;

public class zigZagTreeTraversal {



    Name Of The problem :- ZigZag Tree Traversal

    POTD :- 21-march-2024
    Given a binary tree with n nodes. Find the zig-zag level order traversal of the binary tree.

Example 1:

Input:
        1
      /   \
     2    3
    / \    /   \
   4   5 6   7
Output:
1 3 2 4 5 6 7
Example 2:

Input:
           7
        /     \
       9      7
     /  \      /   
    8   8  6     
   /  \
  10  9 
Output:
7 7 9 8 8 6 9 10 
Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the zig-zag level-order traversal of the tree.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 105


-----------------------------------------------------------------------------------------------------------------------------------------------------

//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    
	    ArrayList<Integer> al = new ArrayList<>();
	    //Add your code here.
	    Stack<Node> s1 = new Stack<>();
	    Stack<Node> s2 = new Stack<>();
	    
	    s1.push(root);
	    while(!s1.isEmpty() || !s1.isEmpty())
	    {
	        
	        while(!s1.isEmpty())
	       {
	           Node temp  = s1.pop();
	           al.add(temp.data);
	           
	           if (temp.left!=null)
	           {
	                s2.push(temp.left);
	           }
	           
	           if(temp.right!=null)
	           {
	                s2.push(temp.right);
	           }
	       }
	    
	        
	        while(!s2.isEmpty())
	        {   
	            Node temp = s2.pop();
	               al.add(temp.data);
	            
	            if(temp.right!=null)
	           {
	                s1.push(temp.right);
	           }
	           
	           if (temp.left!=null)
	           {
	                s1.push(temp.left);
	           }
	            
	        }
	    }
	    
	    return al;
	}
}
    
}
