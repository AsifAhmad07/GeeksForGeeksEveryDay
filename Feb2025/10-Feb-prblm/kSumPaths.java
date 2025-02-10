package 10-Feb-prblm;

public class kSumPaths {


    Name Of The problem :- K Sum Paths


    POTD :- 10-February-2025

    Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

Examples:

Input: k = 7   

Output: 3
Explanation: The following paths sum to k 
 
Input: k = 3
   1
  /  \
2     3
Output: 2
Explanation:
Path 1 : 1 -> 2 (Sum = 3)
Path 2 : 3 (Sum = 3)
Constraints:

1 ≤ number of nodes ≤ 104
-100 ≤ node value ≤ 100
-109 ≤ k ≤ 109


*****************************************************************************************************************************************************


/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int output = 0;
     public int sumK(Node root, int k) {
         // code here
         ArrayList<Integer> paths = new ArrayList<>();
         sumKUtils(root, k, paths);
         return output;
     }
     
     void sumKUtils(Node root, int k, ArrayList<Integer> paths){
         if(root == null){
             return;
         }
         
         paths.add(root.data);
         int sum = 0;
         for(int i = paths.size() - 1; i >=0; --i){
             sum += paths.get(i);
             if(sum == k){
                 ++output;
             }
         }
         sumKUtils(root.left, k, paths);
         sumKUtils(root.right, k, paths);
         paths.remove(paths.size() - 1);
     }
 }
    
}
