package 19-Dec-prblm;

public class kthMissingPositiveNumberinaSortedArray {

    Name of The Problem :- Kth Missing Positive Number in a Sorted Array

    POTD :- 19-December-2024

    Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

Examples :

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.
Constraints:
1 <= arr.size() <= 105
1 <= k <= 105
1 <= arr[i]<= 106

*****************************************************************************************************************************************************

class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        
         int lo=0, hi = arr.length-1;
        int ans = arr.length + k;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] > mid + k){
                hi = mid - 1;
                ans = mid + k;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
    
}
