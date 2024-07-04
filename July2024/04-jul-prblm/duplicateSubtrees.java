package 04-jul-prblm;

public class duplicateSubtrees {

    Name Of The Problem :- Duplicate Subtrees

    POTD :- 04-July-2024

    Given a binary tree, your task is to find all duplicate subtrees from the given binary tree.

Duplicate Subtree : Two trees are duplicates if they have the same structure with the same node values.

Note:  Return the root of each tree in the form of a list array & the driver code will print the tree in pre-order tree traversal in lexicographically increasing order.

Examples:

Input : 
 
Output: 2 4   
        4
Explanation: The above tree have two duplicate subtrees.i.e 
  2
 /
4  and 4. Therefore, you need to return the above tree root in the form of a list.  
Input:     5
          / \
         4   6
        / \
       3   4
          / \
         3   6
Output: 
3
6
Explanation: In the above tree, there are two duplicate subtrees.i.e
3 and 6. Therefore, you need to return the above subtrees root in the form of a list. Here, 4 3  is not considered because for a subtree to be equal, it should have the same values as well as structure. If we consider the first subtree on the left, it has  
two children, 3 on the left and 4 3 6   on the right. And for the second subtree it has 3 on the left and 6 on the right.
Since the structures are not same for the subtrees hence they are not equal
Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1<= height of binary tree <=103

*****************************************************************************************************************************************************


class Solution {
    String help(Node root,List<Node> ans,HashMap<String,Integer> mm){
      if(root==null)return "#";
      String temp = Integer.toString(root.data)+" "+help(root.left,ans,mm)+" "+help(root.right,ans,mm);
      if(mm.get(temp)!=null && mm.get(temp)==1)ans.add(root);
      mm.put(temp,mm.getOrDefault(temp,0)+1);
      return temp;
  }
  public List<Node> printAllDups(Node root) {
      // code here
       List<Node> ans = new ArrayList<>();
      HashMap<String,Integer> mm = new HashMap<>();
      help(root,ans,mm);
      return ans;
  }
}
    
}
