import java.util.ArrayList;

import org.w3c.dom.Node;

package 02-May-prblm;

public class serializeanddeserializeabinarytree {

    

    Name Of The Problem :- Serialize and deserialize a binary tree


    POTD :- 02-May-2024


    Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

Example 1:

Input:
      1
    /   \
   2     3
Output: 
2 1 3
Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 
40 20 60 10 30
Your Task:
The task is to complete two functions serialize which takes the root node of the tree as input and stores the tree into an array and deSerialize which deserializes the array to the original tree and returns the root of it.

Expected Time Complexity: O(Number of nodes).
Expected Auxiliary Space: O(Number of nodes).

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 109

*****************************************************************************************************************************************************

/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/


class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    ArrayList<Integer> al;
    public ArrayList<Integer> serialize(Node root) {
        // code here
        al = new  ArrayList<Integer>();
           fun(root);
           return al;
    }
    void fun(Node root){
        if(root==null){
            al.add(-1);
            return;
        }
        al.add(root.data);
        fun(root.left);
        fun(root.right);
    }

    // Function to deserialize a list and construct the tree.
    int index;
    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        index=0;
        return dfs(A);
    }
    Node dfs(ArrayList<Integer> A){
        if(index==A.size()) return null;
        
        int val = A.get(index);
        index++;
        
        if(val==-1) return null;
        
        Node root = new Node(val);
        root.left = dfs(A);
        root.right = dfs(A);
        
        return root;
        
    }
};



}