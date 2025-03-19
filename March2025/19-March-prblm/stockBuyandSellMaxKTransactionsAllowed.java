package 19-March-prblm;

public class stockBuyandSellMaxKTransactionsAllowed {


    Name Of The Problem :- Stock Buy and Sell – Max K Transactions Allowed


    POTD :- 19-March-2025

    In the stock market, a person buys a stock and sells it on some future date. You are given an array prices[] representing stock prices on different days and a positive integer k, find out the maximum profit a person can make in at-most k transactions.

A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.

Examples :

Input: prices[] = [10, 22, 5, 80], k = 2
Output: 87
Explaination:
1st transaction: Buy at 10 and sell at 22. 
2nd transaction : Buy at 5 and sell at 80.
Total Profit will be 12 + 75 = 87.
Input: prices[] = [20, 580, 420, 900], k = 3
Output: 1040
Explaination: 
1st transaction: Buy at 20 and sell at 580. 
2nd transaction : Buy at 420 and sell at 900.
Total Profit will be 560 + 480 = 1040.
Input: prices[] = [100, 90, 80, 50, 25],  k = 1
Output: 0
Explaination: Selling price is decreasing continuously
leading to loss. So seller cannot have any profit.
Constraints:
1 ≤ prices.size() ≤ 103
1 ≤ k ≤ 200
1 ≤ prices[i] ≤ 103


*****************************************************************************************************************************************************


class Solution {
    static int dp[][][];
    static int maxProfit(int prices[], int k) {
        dp = new int[prices.length][k+1][2];
        
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        
        return solve(prices,k,0,0);
    }
    
    static int solve(int prices[], int k, int idx, int holding){
        if(idx == prices.length){
            return 0;
        }
        if(k == 0){
            return 0;
        }
        
        if(dp[idx][k][holding] != -1){
            return dp[idx][k][holding];
        }
        int transaction = 0;
        if(holding == 1){
            transaction = prices[idx] + solve(prices,k-1,idx+1,0);
        } else {
            transaction = -prices[idx] + solve(prices,k,idx+1,1);
        }
        int np_transact = solve(prices,k,idx+1,holding);
        return dp[idx][k][holding] = Math.max(transaction, np_transact);
    }
}
    
}
