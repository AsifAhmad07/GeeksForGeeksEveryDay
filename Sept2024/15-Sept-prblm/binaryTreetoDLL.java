package 15-Sept-prblm;

public class binaryTreetoDLL {


    Name Of The Problem :- Binary Tree to DLL

    POTD :- 15-September-2024

    Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place. The left and right pointers in nodes will be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be the same as the order of the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

Note: h is the tree's height, and this space is used implicitly for the recursion stack.

TreeToList

Examples:

Input:
      1
    /  \
   3    2
Output:
3 1 2 
2 1 3

Explanation: DLL would be 3<=>1<=>2
Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30 
30 10 60 20 40

Explanation:  DLL would be 40<=>20<=>60<=>10<=>30.
Expected Time Complexity: O(no. of nodes)
Expected Space Complexity: O(height of the tree)

Constraints:
1 ≤ Number of nodes ≤ 105
0 ≤ Data of a node ≤ 105

*****************************************************************************************************************************************************

//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
     Node head = null, lastNode = null;
    void help(Node root){
        if(root==null)return;
        help(root.left);
        if(head==null)head=root;
        if(lastNode!=null)lastNode.right=root;
        root.left=lastNode;
        lastNode=root;
        help(root.right);
    }
    Node bToDLL(Node root)
    {
	//  Your code here	
	help(root);
	    return head;
    }
}
    
}
