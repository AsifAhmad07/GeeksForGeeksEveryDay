package 25-Nov-prblm;

public class maximumProductSubarray {

    Name Of The Problem :- Maximum Product Subarray


    POTD :- 25-November-2024

    Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr.

Note: It is guaranteed that the output fits in a 32-bit integer.

Examples

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.
Input: arr[] = [-1, -3, -10, 0, 60]
Output: 60
Explanation: The subarray with maximum product is {60}.
Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements. 
Constraints:
1 ≤ arr.size() ≤ 106
-10  ≤  arr[i]  ≤  10


*****************************************************************************************************************************************************


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        
        int ans=Integer.MIN_VALUE,productStart=1,productEnd=1,n=arr.length;
        for(int i=0;i<n;i++){
            productStart*=arr[i];
            productEnd*=arr[n-1-i];
            ans=Math.max(ans,Math.max(productStart,productEnd));
            if(productStart==0)productStart=1;
            if(productEnd==0)productEnd=1;
        }
        return ans;
    }
}
    
}
