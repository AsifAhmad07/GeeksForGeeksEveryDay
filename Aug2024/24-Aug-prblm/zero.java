package 24-Aug-prblm;

public class zero-1KnapsackProblem {

    Name Of The Problem :- 0 - 1 Knapsack Problem

    POTD :- 24-August-2024

    You are given weights and values of items, and put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val and wt which represent values and weights associated with items respectively. Also given an integer W which represents knapsack capacity, find out the maximum sum values subset of val[] such that the sum of the weights of the corresponding subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don't pick it (0-1 property).

Examples :

Input: W = 4, val[] = {1,2,3}, wt[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3. 
Input: W = 3, val[] = {1,2,3}, wt[] = {4,5,6}
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
2 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ val[i] ≤ 1000


*****************************************************************************************************************************************************

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
     static int help(int n,int w,int wt[],int val[],int index,int dp[][]){
        if(index==n)return 0;
        if(dp[index][w]!=-1)return dp[index][w];
        int nonPick=0,pick=0;
        nonPick = help(n,w,wt,val,index+1,dp);
        if(w>=wt[index]){
            pick = val[index]+help(n,w-wt[index],wt,val,index+1,dp);
        }
        return dp[index][w] = Math.max(nonPick,pick);
    }
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
         int n = wt.length;
        int dp[][] = new int[n][W+1];
        for(int temp[]:dp){
            Arrays.fill(temp,-1);
        }
        return help(n,W,wt,val,0,dp);
    }
}

    
}
