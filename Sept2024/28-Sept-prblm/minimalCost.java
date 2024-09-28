package 28-Sept-prblm;

public class minimalCost {


    Name Of The Problem :- Minimal Cost

    POTD :- 28-September-2024

    There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
Input: k = 1, arr[]= [10, 20, 10]
Output: 20
Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.
Expected Time Complexity: O(n*k)
Expected Auxilary Space: O(n)

Constraint:
1<= arr.size() <=104
1 <= k <= 100
1 <= arr[i] <= 104


*****************************************************************************************************************************************************


class Solution {
    int help(int i,int k,int arr[],int dp[]){
       if(i==arr.length-1)return 0;
       if(dp[i]!=-1)return dp[i];
       int ans = Integer.MAX_VALUE;
       for(int j=i+1;j<=i+k && j<arr.length;j++){
           int cost = Math.abs(arr[i]-arr[j])+help(j,k,arr,dp);
           ans=Math.min(ans,cost);
       }
       return dp[i] = ans;
   }
   public int minimizeCost(int k, int arr[]) {
       // code here
        int dp[] = new int[arr.length];
       Arrays.fill(dp,-1);
       return help(0,k,arr,dp);
   }
}

    
}
