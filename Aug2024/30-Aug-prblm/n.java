import com.apple.laf.AquaProgressBarUI;

package 30-Aug-prblm;

public class n-QueenProblem { 



  Name Of The Problem :- N-Queen Problem
  
  
  POTD :- 30-August-2024

  The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].



Examples:

Input: 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.
Input: 4
Output: [[2 4 1 3 ],[3 1 4 2 ]]
Explaination: These are the 2 possible solutions.
Expected Time Complexity: O(n!)
Expected Auxiliary Space: O(n2) 

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
