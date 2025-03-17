package 17-March-prblm;

public class subsetSumProblem {


    Name Of The Problem :- Subset Sum Problem

    POTD :- 17-March-2025

    Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 104

*****************************************************************************************************************************************************

class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        Boolean dp[][]=new Boolean[n][sum+1];
        return rec(n-1,arr,sum,dp);
    }
    private static Boolean rec(int id,int arr[],int sum,Boolean dp[][]){
        if(sum==0) return true;
        if(id<0 || sum<0) return false;
        if(dp[id][sum]!=null) return dp[id][sum];
        Boolean p=rec(id-1,arr,sum-arr[id],dp);
        Boolean np=rec(id-1,arr,sum,dp);
        return dp[id][sum]=p || np;
    }
}
    
}
