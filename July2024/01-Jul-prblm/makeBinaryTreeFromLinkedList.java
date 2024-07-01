import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

import apple.laf.JRSUIUtils.Tree;

package 01-july-2024

public class makeBinaryTreeFromLinkedList {

    

    Name Of The Problem :- Make Binary Tree From Linked List

    POTD :- 01-July-2024


    Given a Linked List Representation of Complete Binary Tree. Your task is to construct the Binary tree from the given linkedlist and return the root of the tree.
The result will be judged by printing the level order traversal of the Binary tree. 
Note: The complete binary tree is represented as a linked list in a way where if the root node is stored at position i, its left, and right children are stored at position 2*i+1, and 2*i+2 respectively. H is the height of the tree and this space is used implicitly for the recursion stack.

Examples:

Input: list = 1->2->3->4->5
Output: 1 2 3 4 5
Explanation: The tree would look like
      1
    /   \
   2     3
 /  \
4   5
Now, the level order traversal of
the above tree is 1 2 3 4 5.
Input: list = 5->4->3->2->1
Output: 5 4 3 2 1
Explanation: The tree would look like
     5
   /  \
  4    3
 / \
2   1
Now, the level order traversal of
the above tree is 5 4 3 2 1.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
Constraints:
1 <= size(list) <= 105
1 <= node.data <= 105



*****************************************************************************************************************************************************


class Solution {
    public Tree convert(Node head, Tree node) {
        node = new Tree(head.data);
        bfs(head.next,node);
        return node;
    }
      
    static void bfs(Node head,Tree node){
        
        Queue<Tree> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Tree par = q.remove();
            
            if(head==null)  return;
            par.left = new Tree(head.data);
            head=head.next;
            q.add(par.left);
            
            if(head==null)  return;
            par.right = new Tree(head.data);
            head=head.next;
            q.add(par.right);
        }
        
    }
}
}