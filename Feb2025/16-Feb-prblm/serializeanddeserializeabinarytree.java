package 16-Feb-prblm;

public class serializeanddeserializeabinarytree {


    Name Of The Problem :- Serialize and deserialize a binary tree

    POTD :- 16-February-2025

    Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

Examples :

Input: root = [1, 2, 3]
      
Output: [2, 1, 3]
Input: root = [10, 20, 30, 40, 60, N, N]
      
Output: [40, 20, 60, 10, 30]
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
   public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        serialize(root, arr);
        return arr;
    }
    
    void serialize(Node root, ArrayList<Integer> arr){
        if(root == null){
            arr.add(-1);
            return;
        }
        
        arr.add(root.data);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        int[] index = new int[1];
        return deSerialize(arr, index);
    }
    
    Node deSerialize(ArrayList<Integer> arr, int[] index){
        if(arr.get(index[0]) == -1){
            ++index[0];
            return null;
        }
        
        Node newNode = new Node(arr.get(index[0]));
        ++index[0];
        newNode.left = deSerialize(arr, index); 
        newNode.right = deSerialize(arr, index);
        return newNode;
    }
}
    
}
