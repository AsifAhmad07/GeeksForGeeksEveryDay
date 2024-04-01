package 01-April-prblm;

public class PairsviolatingtheBSTproperty {


    Name Of The Problem :- Pairs violating the BST property


    POTD :- 01-April-2024

    Given a binary tree with n nodes, find the number of pairs violating the BST property.
BST has the following properties:-

Every node is greater than its left child and less than its right child.
Every node is greater than the maximum value of in its left subtree and less than the minimum value in its right subtree.
The maximum in the left sub-tree must be less than the minimum in the right subtree.
Example 1:

Input : 
n = 5
Input tree
    
Output :
5
Explanation : 
Pairs violating BST property are:-
(10,50), 10 should be greater than its left child value.
(40,30), 40 should be less than its right child value.
(50,20), (50,30) and (50,40), maximum of left subtree of 10 is 50 greater than 20, 30 and 40 of its right subtree.
Example 2:

Input : 
n = 6
Input tree

Output :
8
Explanation :
There are total 8 Pairs which violation the BST properties.
Your task :
You don't have to read input or print anything. Your task is to complete the function pairsViolatingBST() that takes the root of the tree and n as input and returns number of pairs violating BST property.
 
Expected Time Complexity: O(n*logn)
Expected Space Complexity: O(n)
 
Your Task :
1 <= n <= 2*104
-109 <= node->data <= 109


-----------------------------------------------------------------------------------------------------------------------------------------------------


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
     static int k;
    public static int pairsViolatingBST(int n, Node root) {
        // code here
        int cnt=0;
       k=0;
        int arr[] = new int[n];
         inorder(root, arr);
         
        for(int i=0; i<n ;i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j])
                cnt++;
            }
        }
        return cnt;
    }
     static void inorder(Node root, int arr[]) {
        if (root == null) {
            return;
        }

        inorder(root.left, arr);
       arr[k++]= root.data;
        inorder(root.right, arr);
    }
}

    
}
