package 23-Dec-prblm;

public class searchinarow-wisesortedmatrix {

    Name Of The Problem :- Search in a row-wise sorted matrix


    POTD :- 23-December-2024

    Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

Examples :

Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
Output: true
Explanation: 9 is present in the matrix, so the output is true.
Input: mat[][] = [[19, 22, 27, 38, 55, 67]], x = 56
Output: false
Explanation: 56 is not present in the matrix, so the output is false.
Input: mat[][] = [[1, 2, 9],[65, 69, 75]], x = 91
Output: false
Explanation: 91 is not present in the matrix.
Constraints:
1 <= n, m <= 1000
1 <= mat[i][j] <= 105
1 <= x <= 105


*****************************************************************************************************************************************************


class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
         int n=mat.length,m=mat[0].length;
        for(int i=0;i<n;i++){
            if (x < mat[i][0] || x > mat[i][m - 1])continue;
            int low=0,high=m-1,mid;
            while(low<=high){
                mid=(low+high)/2;
                int temp = mat[i][mid];
                if(temp==x)return true;
                else if(temp<x)low=mid+1;
                else high=mid-1;
            }
        }
        return false;
    }
}

    
}
