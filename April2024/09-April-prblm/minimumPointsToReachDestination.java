package 09-April-prblm;

public class minimumPointsToReachDestination {



    Name Of The Problem :- Minimum Points To Reach Destination


    POTD :- 09-April-2024

    Given a m*n grid with each cell consisting of positive, negative, or zero point. We can move across a cell only if we have positive points. Whenever we pass through a cell, points in that cell are added to our overall points, the task is to find minimum initial points to reach cell (m-1, n-1) from (0, 0) by following these certain set of rules :
1. From a cell (i, j) we can move to (i + 1, j) or (i, j + 1).
2. We cannot move from (i, j) if your overall points at (i, j) are <= 0.
3. We have to reach at (n-1, m-1) with minimum positive points i.e., > 0.

Example 1:

Input: 
m = 3, n = 3 
points = {{-2,-3,3}, 
          {-5,-10,1},
          {10,30,-5}} 
Output: 
7 
Explanation: 7 is the minimum value to reach the destination with positive throughout the path. Below is the path. (0,0) -> (0,1) -> (0,2) -> (1, 2) -> (2, 2) We start from (0, 0) with 7, we reach (0, 1) with 5, (0, 2) with 2, (1, 2) with 5, (2, 2) with and finally we have 1 point (we needed greater than 0 points at the end).
Example 2:
Input:
m = 3, n = 2
points = {{2,3},  
          {5,10},  
          {10,30}} 
Output: 
1 
Explanation: Take any path, all of them are positive. So, required one point at the start
Your Task:  
You don't need to read input or print anything. Complete the function minPoints() which takes m,n and 2-d vector points as input parameters and returns the minimum initial points to reach cell (m-1, n-1) from (0, 0).

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ m ≤ 103  
1 ≤ n ≤ 103
-103 ≤ points[i][j] ≤ 103


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    static int help(int i,int j,int n,int m,int points[][],int dp[][]){
        if(i==m-1 && j==n-1)return 1-points[i][j];
        if(i==m || j==n)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        int a = help(i,j+1,n,m,points,dp);
        int b = help(i+1,j,n,m,points,dp);
        return dp[i][j] = Math.max(1,Math.min(a,b)-points[i][j]);
    }
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        
        int dp[][] = new int[m][n];
        for(int []temp:dp)Arrays.fill(temp,-1);
	    return help(0,0,n,m,points,dp);
    }
}

    
}
