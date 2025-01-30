package 30-Jan-prblm;

public class nQueenProblem {


    Name Of The Problem :- N-Queen Problem

    POTD :- 30-January-2025

    The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
For eg. below figure represents a chessboard [3 1 4 2].



Examples:

Input: n = 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.
Input: n = 4
Output: [[2 4 1 3 ] [3 1 4 2 ]]
Explaination: There are 2 possible solutions for n = 4.
Input: n = 2
Output: []
Explaination: There are no possible solutions for n = 2.
Constraints:
1 ≤ n ≤ 10


*****************************************************************************************************************************************************

class Solution {
    boolean canPut(int row,int col,ArrayList<Integer> temp){
       int r = row, c= col;
       while(r>=0 && c>=0){
           if(temp.get(r)==c+1)return false;
           r--;
           c--;
       }
       r = row;
       c = col;
       while(r>=0){
           if(temp.get(r)==c+1)return false;
           r--;
       }
       r = row;
       c = col;
       while(r>=0 && c<temp.size()){
           if(temp.get(r)==c+1)return false;
           r--;
           c++;
       }
       return true;
   }
   void help(int n,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp,int row){
       if(row==n){
           ans.add(temp);
           return;
       }
       for(int col=0;col<n;col++){
           if(canPut(row,col,temp)){
               temp.set(row,col+1);
               ArrayList tempCopy = new ArrayList(temp);
               help(n,ans,tempCopy,row+1);
               temp.set(row,0);
           }
       }
   }
   public ArrayList<ArrayList<Integer>> nQueen(int n) {
       // code here
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       ArrayList<Integer> temp = new ArrayList<>();
       for(int i=0;i<n;i++)temp.add(0);
       help(n,ans,temp,0);
       return ans;
   }
}
    
}
