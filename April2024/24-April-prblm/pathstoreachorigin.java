package 24-April-prblm;

public class pathstoreachorigin {



    Name Of The Problem :- Paths to reach origin


    Date :- 24-April-2024

    You are standing on a point (x, y) and you want to go to the origin (0, 0) by taking steps either left or down i.e. from each point you are allowed to move either in (x-1, y) or (x, y-1). Find the number of paths from point to origin.

Example 1:

Input:
x = 3, y = 0 
Output: 
1
Explanation: Path used was -  (3,0)  --> ( 2,0) --> (1,0) --> (0,0).We can see that there is no other path than this, so we return 1.
Example 2:

Input:
x = 3, y = 6
Output: 
84 
Explanation:
There are total 84 possible paths.
Your Task:
Since this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function ways() that takes integer x and y as parameters and returns the total number of paths from point(x,y) to the origin(0,0) % 1000000007.

Expected Time Complexity: O(x*y).
Expected Auxiliary Space: O(x*y).

Constraints:
0 ≤ x, y ≤ 500


*****************************************************************************************************************************************************Auxiliary

class Solution
{
     static int mod = 1000000007;
    static int help(int x,int y,int dp[][]){
        if(x==0 && y==0)return 1;
        if(x<0 || y<0)return 0;
        if(dp[x][y]!=-1)return dp[x][y];
        int a = help(x-1,y,dp);
        int b = help(x,y-1,dp);
        return dp[x][y] = (a+b)%mod;
    }
    public static int ways(int n, int m)
    {
        // complete the function
         int dp[][] = new int[n+1][m+1];
        for(int temp[]:dp)Arrays.fill(temp,-1);
        return help(n,m,dp);
    }
}
    
}
