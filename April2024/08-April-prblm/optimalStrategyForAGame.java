package 08-April-prblm;

public class optimalStrategyForAGame {


    Name Of The Problem :- Optimal Strategy For A Game


    POTD :- 08-April-2024

    You are given an array arr of size n. The elements of the array represent n coin of values v1, v2, ....vn. You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:

Input:
n = 4
arr[] = {5, 3, 7, 10}
Output: 
15
Explanation: The user collects maximum
value as 15(10 + 5). It is guarantee that we cannot get more than 15 by any possible moves.
Example 2:

Input:
n = 4
arr[] = {8, 15, 3, 7}
Output: 
22
Explanation: The user collects maximum
value as 22(7 + 15). It is guarantee that we cannot get more than 22 by any possible moves.
Your Task:
Complete the function maximumAmount() which takes an array arr[] (represent values of n coins) and n as a number of coins as a parameter and returns the maximum possible amount of money you can win if you go first.

Expected Time Complexity : O(n*n)
Expected Auxiliary Space: O(n*n)

Constraints:
2 <= n <= 103
1 <= arr[i] <= 106

-----------------------------------------------------------------------------------------------------------------------------------------------------


class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long help(int i,int j,int arr[],long dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        long sum1 = arr[i],sum2=arr[j];
        sum1+=Math.min(help(i+2,j,arr,dp),help(i+1,j-1,arr,dp));
        sum2+=Math.min(help(i+1,j-1,arr,dp),help(i,j-2,arr,dp));
        return dp[i][j] = Math.max(sum1,sum2);
    }
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        
        long dp[][]=new long[n][n];
        for(long temp[]:dp)Arrays.fill(temp,-1);
        return help(0,n-1,arr,dp);
    }
}

    
}
