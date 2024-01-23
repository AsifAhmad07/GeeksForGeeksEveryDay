package 20-jan-prblm;

public class distributeCandiesInBinaryTree {

    /*
     * Name Of The Problem :- Distribute candies in a binary tree
     * POTD :- 20-jan-2024 
     * 
     * Given a binary tree with N nodes, in which each node value represents number of candies present at that node. In one move, one may choose two adjacent nodes and move only one candy from one node to another (the move may be from parent to child, or from child to parent.) 
The task is to find the number of moves required such that every node has exactly one candy.
Note that the testcases are framed such that it is always possible to achieve a configuration in which every node has exactly one candy, after some moves.

Example 1:

Input :      3
           /   \
          0     0 
Output : 2
Explanation: 
From the root of the tree, we move one 
candy to its left child, and one candy to
its right child.
Example 2:

Input :      0
           /   \
          3     0  
Output : 3
Explanation : 
From the left child of the root, we move 
two candies to the root [taking two moves]. 
Then, we move one candy from the root of the 
tree to the right child.
Your task :
You don't have to read input or print anything. Your task is to complete the function distributeCandy() which takes the root of the tree as input and returns the number of moves required such that every node has exactly one candy.
 
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of the tree)
 
Constraints:
1 <= N <= 104
0 <= Value of each node <= 104

     */
    //User function Template for Java

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
}*/


class Solution
{
    
    static int ans;
    static int solve(Node root){
        if(root == null){
            return 0;
        }
        int left_profit = solve(root.left);
        int right_profit = solve(root.right);
        ans += Math.abs(left_profit) + Math.abs(right_profit);
        return root.data + left_profit + right_profit - 1;
    }
    public static int distributeCandy(Node root)
    {
        //code here
         ans = 0;
        solve(root);
        return ans;
    }
}
    
}
