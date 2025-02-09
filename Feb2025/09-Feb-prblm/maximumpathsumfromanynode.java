package 09-Feb-prblm;

public class maximumpathsumfromanynode {


    Name Of The problem :- Maximum path sum from any node

    POTD :- 09-February-2025

    Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation: 

Max path sum is represented using green colour nodes in the above binary tree.
Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation: 

Max path sum is represented using green colour nodes in the above binary tree.
Constraints:
1 ≤ number of nodes ≤ 103
-104 ≤ node->data ≤ 104

*****************************************************************************************************************************************************


/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        // your code goes here
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(node, res);
        return res[0];
    
    }
      int dfs(Node node, int[] res){
        if(node == null){
            return 0;
        }
        
        int l = dfs(node.left, res);
        int r = dfs(node.right, res);
        int temp = Math.max(Math.max(l, r) + node.data, node.data);
        int ans = Math.max(l + r + node.data, temp);
        res[0] = Math.max(res[0], ans);
        return temp;
}
}

    
}
