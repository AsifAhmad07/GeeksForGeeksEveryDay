package 24-Nov-prblm;

public class kadane'sAlgorithm {


    Name Of The Problem :- Kadane's Algorithm


    POTD :- 24-November-2024

    Given an integer array arr[]. You need to find the maximum sum of a subarray.

Examples:

Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray {-2} has the largest sum -2.
Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.
Constraints:
1 ≤ arr.size() ≤ 105
-109 ≤ arr[i] ≤ 104

*****************************************************************************************************************************************************

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        
        int sum=0,ans=Integer.MIN_VALUE,n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            ans=Math.max(ans,sum);
            if(sum<0)sum=0;
        }
        return ans;
    }
}

    
}
