package 18-March-prblm;

public class partitionEqualSubsetSum {


    Name Of The Problem :- Partition Equal Subset Sum

    POTD :- 18-March-2025

    Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].
Input: arr = [1, 3, 5]
Output: false
Explanation: This array can never be partitioned into two such parts.
Constraints:
1 ≤ arr.size ≤ 100
1 ≤ arr[i] ≤ 200

*****************************************************************************************************************************************************


class Solution {
    static Boolean[][] dp;
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0) return false;
        int x = sum / 2;
        dp = new Boolean[arr.length][x+1];
        return helper(0, arr, x);
    }
    static boolean helper(int ind, int[] arr, int sum){
        if(ind == arr.length){
            return sum == 0 ? true : false;
        }
        if(dp[ind][sum] != null) return dp[ind][sum];
        boolean res = false;
        if(arr[ind] <= sum){
            res |= helper(ind+1, arr, sum - arr[ind]);
        }
        res |= helper(ind+1, arr, sum);
        return dp[ind][sum] = res;
    }
}
    
}
