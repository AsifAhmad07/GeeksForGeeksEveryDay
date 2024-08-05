package 05-Aug-prblm;

public class bottomViewofBinaryTree {


    Name Of The Problem :- Bottom View of Binary Tree


    POTD :- 05-August-2024

    Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree, the output should be 5 10 4 14 25.

Examples :

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.

Thus bottom view of the binary tree will be 3 1 2.
Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105

*****************************************************************************************************************************************************


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
         ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Map<Integer,Integer> mm = new HashMap<>();
        root.hd=0;
        q.add(root);
        int mn=0,mx=0;
        while(!q.isEmpty()){
            Node temp = q.remove();
            mm.put(temp.hd,temp.data);
            mn=Math.min(mn,temp.hd);
            mx=Math.max(mx,temp.hd);
            if(temp.left!=null){
                temp.left.hd=temp.hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd=temp.hd+1;
                q.add(temp.right);
            }
        }
        for(int i=mn;i<=mx;i++){
            ans.add(mm.get(i));
        }
        return ans;
    }
}
    
}
