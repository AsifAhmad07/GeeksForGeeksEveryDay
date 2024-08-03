package 03-Aug-prblm;

public class theCelebrityProblem {


    Name Of The Problem :- The Celebrity Problem

    POTD :- 03-August-2024

    A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people.  A square matrix mat is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[0 1 0],
                [0 0 0], 
                [0 1 0]]
Output: 1
Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity. 
Input: mat[][] = [[0 1],
                [1 0]]
Output: -1
Explanation: The two people at the party both know each other. None of them is a celebrity.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= mat.size()<= 3000
0 <= mat[i][j]<= 1

*****************************************************************************************************************************************************Auxiliary
class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int ans=-1,j=0,n=mat.length;
        for(int i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(mat[i][j]==1)break;
            }
            if(j==n){
                for(j=0;j<n;j++){
                    if(i!=j && mat[j][i]==0)break;
                }
                if(j==n)ans=i;
                break;
            }
        }
        return ans;
    }
}
    
}
