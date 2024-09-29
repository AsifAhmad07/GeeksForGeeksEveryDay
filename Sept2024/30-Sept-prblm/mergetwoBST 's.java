package 30-Sept-prblm;

public class mergetwoBST 's {



    Name Of The Problem :- Merge two BST 's

    POTD :- 30-september-2024

    Given two BSTs, return elements of merged BSTs in sorted form.

Examples :

Input:
BST1:
       5
     /   \
    3     6
   / \
  2   4  
BST2:
        2
      /   \
     1     3
            \
             7
            /
           6
Output: 1 2 2 3 3 4 5 6 6 7
Explanation: After merging and sorting the two BST we get 1 2 2 3 3 4 5 6 6 7.
Input:
BST1:
       12
     /   
    9
   / \    
  6   11
BST2:
      8
    /  \
   5    10
  /
 2
Output: 2 5 6 8 9 10 11 12
Explanation: After merging and sorting the two BST we get 2 5 6 8 9 10 11 12.
Expected Time Complexity: O((m+n)*log(m+n))
Expected Auxiliary Space: O(Height of BST1 + Height of BST2 + m + n)

Constraints:
1 ≤ Number of Nodes, value of nodes ≤ 105

*****************************************************************************************************************************************************


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    s Solution {
     void help(Node root,List<Integer> temp){
        if(root==null)return;
        help(root.left,temp);
        temp.add(root.data);
        help(root.right,temp);
    }
    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
          List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        help(root1,first);
        help(root2,second);
        int i=0,j=0;
        while(i<first.size() && j<second.size()){
            if(first.get(i)<=second.get(j))ans.add(first.get(i++));
            else ans.add(second.get(j++));
        }
        while(i<first.size())ans.add(first.get(i++));
        while(j<second.size())ans.add(second.get(j++));
        return ans;
    }
}

    
}
