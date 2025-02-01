package 02-Feb-prblm;

public class levelordertraversal {

    Name Of The problem :- Level order traversal

    POTD :- 02-February-2025

    Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

Examples:

Input: root[] = [1, 2, 3]

Output: [[1], [2, 3]]
Input: root[] = [10, 20, 30, 40, 50]

Output: [[10], [20, 30], [40, 50]]
Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]

Output: [[1], [3, 2], [4], [6, 5]]
Constraints:

1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 109


*****************************************************************************************************************************************************


/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
         Queue<Node> q = new LinkedList();
         q.add(root);
         while(!q.isEmpty()){
             int size = q.size();
             ArrayList<Integer> level = new ArrayList();
             while(size-->0){
                 Node tmp = q.poll();
                 level.add(tmp.data);
                 if(tmp.left!=null){
                     q.add(tmp.left);
                 }
                 if(tmp.right!=null){
                     q.add(tmp.right);
                 }
                 
             }
             ans.add(level);
         }
         return ans;
    }
}
    
}
