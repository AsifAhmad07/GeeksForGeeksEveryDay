package 14-march-prblm;

public class largestSubSquareSurroundedByX {

    Name Of The Problem :- Largest subsquare surrounded by X


    POTD :- 14-march-2024

    Given a square matrix a of size n x n, where each cell can be either 'X' or 'O', you need to find the size of the largest square subgrid that is completely surrounded by 'X'. More formally you need to find the largest square within the grid where all its border cells are 'X'.

Example 1:

Input:
n = 2
a = [[X,X],
     [X,X]]
Output:
2
Explanation:
The largest square submatrix 
surrounded by X is the whole 
input matrix.
Example 2:

Input:
n = 4
a = [[X,X,X,O],
     [X,O,X,X],
     [X,X,X,O],
     [X,O,X,X]]
Output:
3
Explanation:
Here,the input represents following 
matrix of size 4 x 4
X X X O
X O X X
X X X O
X O X X
The square submatrix starting at 
(0,0) and ending at (2,2) is the 
largest submatrix surrounded by X.
Therefore, size of that matrix would be 3.
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestSubsquare() which takes the integer n and the matrix a as input parameters and returns the size of the largest subsquare surrounded by 'X'.

Expected Time Complexity: O(n2)
Expected Auxillary Space: O(n2)

Constraints:
1 <= n <= 1000
a[i][j] belongs to {'X','O'} 


-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    int largestSubsquare(int n, char a[][]) {
        // code here
        int left[][] = new int[n][n];
        int top[][] = new int[n][n];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]=='X'){
                    if(i!=0){
                        top[i][j]=top[i-1][j]+1;
                    }
                    else top[i][j]=1;
                    if(j!=0){
                        left[i][j]=left[i][j-1]+1;
                    }
                    else left[i][j]=1;
                }
                int minX=Math.min(top[i][j],left[i][j]);
                while(minX!=0){
                    int k = j-minX+1;
                    int l = i-minX+1;
                    if(top[i][k]>=minX && left[l][j]>=minX){
                        ans=Math.max(ans,minX);
                        break;
                    }
                    minX--;
                }
            }
        }
        return ans;
    }
};
    
}
