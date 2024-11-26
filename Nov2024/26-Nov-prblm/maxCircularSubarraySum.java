package 26-Nov-prblm;

public class maxCircularSubarraySum {



    Name Of The Problem :- Max Circular Subarray Sum

    POTD :- 26-November-2024

    Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

Examples:

Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1] 
Output: 52
Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.
Constraints:
1 <= arr.size() <= 105
-104 <= arr[i] <= 104

*****************************************************************************************************************************************************


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
         int n = arr.length,mn=Integer.MAX_VALUE,mx=Integer.MIN_VALUE,sum1=0,sum2=0,total=0;
        for(int i=0;i<n;i++){
            total+=arr[i];
            sum2=Math.min(arr[i],sum2+arr[i]);
            mn=Math.min(mn,sum2);
            sum1=Math.max(arr[i],sum1+arr[i]);
            mx=Math.max(mx,sum1);
        }
        return Math.max(mx,total-mn);
    }
}

    
}
