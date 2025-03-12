package 12-March-prblm;

public class minCostClimbingStairs {

    Name Of The Problem :- Min Cost Climbing Stairs

    POTD :- 12-March-2025

    Given an array of integers cost[] where cost[i] is the cost of the ith step on a staircase. Once the cost is paid, you can either climb one or two steps. Return the minimum cost to reach the top of the floor.
Assume 0-based Indexing. You can either start from the step with index 0, or the step with index 1.

Examples:

Input: cost[] = [10, 15, 20]
Output: 15
Explanation: Cheapest option is to start at cost[1], pay that cost, and go to the top.



Input: cost[] = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest option is to start on cost[0], and only step on 1s, skipping cost[3].


Constraints:
2 ≤ cost.size() ≤ 105
0 ≤ cost[i] ≤ 999

*****************************************************************************************************************************************************

class Solution {
    
    static int dp[];
  static int minCost(int[]cost,int i){
        if(i >= cost.length) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int a = minCost(cost , i + 1) + cost[i];
        int b = minCost(cost , i + 2) + cost[i];
        int ans = Math.min(a , b);
        dp[i] = ans;
        return ans;
    }
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        
        int N = cost.length;
          dp = new int[N];
        Arrays.fill(dp , -1);
        int ans = Math.min(minCost(cost , 0) , minCost(cost , 1));
        return ans;
        
    }
}
    
}
