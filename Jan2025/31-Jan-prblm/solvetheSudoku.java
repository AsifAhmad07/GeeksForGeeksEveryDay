package 31-Jan-prblm;

public class solvetheSudoku {

    Name Of The Problem :- Solve the Sudoku

    POTD :- 31-January-2025

    Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.

Examples:

Input: mat[][] = 

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
Input: mat[][] = 

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
Constraints:
mat.size() = 9
mat[i].size() = 9
0 ≤ mat[i][j] ≤ 9

*****************************************************************************************************************************************************

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat, 0, 0);
    }
    static boolean solve(int[][] mat, int i, int j){
        if(i==9){
            return true;
        }
        int nextI=0, nextJ=0;
        if(j==8){
           nextI=i+1;
           nextJ=0;
        }
        else {
            nextI=i;
            nextJ=j+1;
        }
        if(mat[i][j]!=0){
            return solve(mat, nextI, nextJ);
        }
        else {
            for(int val=1;val<=9;val++){
                if(isValid(mat, i, j, val)){
                    mat[i][j]=val;
                    if(solve(mat, nextI, nextJ)){
                        return true;
                    }
                    else
                        mat[i][j]=0;
                }
            }
            return false;
        }
    }
    static boolean isValid(int[][] mat, int r, int c, int val){
        for(int i=0;i<9;i++){
            if(mat[i][c]==val || mat[r][i]==val)
            return false;
        }
        
        int strR = (r/3)*3;
        
        int strC = (c/3)*3;
        for(int i=strR;i<strR+3;i++){
            for(int j=strC;j<strC+3;j++){
                if(mat[i][j]==val){
                    return false;
                }
            }
        }
        
        return true;
    }
}
    
}
