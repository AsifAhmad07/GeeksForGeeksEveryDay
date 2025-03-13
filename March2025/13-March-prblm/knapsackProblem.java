package 13-March-prblm;

public class knapsackProblem {


    Name Of The Problem :- 0 - 1 Knapsack Problem

    POTD :- 13-March-2025

    Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
Constraints:
2 ≤ val.size() = wt.size() ≤ 103
1 ≤ W ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103


*****************************************************************************************************************************************************

class Solution {
    static int solve(int capacity,int[] val,int[] wt,int index,int[][] dp){
        if(index==0){
            if(wt[0]<=capacity){
                return val[0];
            }else{
                return 0;
            }
        }
        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }
        int include = 0;
        if(wt[index]<=capacity){
            include = val[index]+solve(capacity-wt[index],val,wt,index-1,dp);
        }
        int exclude = solve(capacity,val,wt,index-1,dp);
        return dp[index][capacity] = Math.max(include,exclude);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W+1];
        for(int i=0;i<val.length;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            }
        }
        return solve(W,val,wt,val.length-1,dp);
        
    }
}
    
}
