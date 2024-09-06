package 06-Sept-prblm;

public class kadane'sAlgorithm {


    Name Of The Problem :- Kadane's Algorithm


    POTD :- 06-September-2024

    Given an integer array arr[]. Find the contiguous sub-array(containing at least one number) that has the maximum sum and return its sum.

Examples:

Input: arr[] = [1, 2, 3, -2, 5]
Output: 9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
Input: arr[] = [-1, -2, -3, -4]
Output: -1
Explanation: Max subarray sum is -1 of element (-1)
Input: arr[] = [5, 4, 7]
Output: 16
Explanation: Max subarray sum is 16 of element (5, 4, 7)
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
-107 ≤ arr[i] ≤ 107


*****************************************************************************************************************************************************

// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
         int n = arr.length;  // Use .length for arrays
        long maxSoFar = arr[0];  // Stores the maximum sum so far
        long currentMax = arr[0];  // Stores the current maximum sum ending at the current index

        // Traverse the array from the second element
        for (int i = 1; i < n; i++) {
            // Either include the current element in the previous subarray or start a new subarray
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return (int) maxSoFar;
    }
}



    
}
