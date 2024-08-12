package 12-Aug-prblm;

public class sumofMiddleelementsoftwosortedarrays {


    Name Of The Problem :- Sum of Middle elements of two sorted arrays

    POTD :- 12-August-2024

    Given 2 sorted integer arrays arr1 and arr2. Find the sum of the middle elements of two sorted arrays arr1 and arr2.

Examples:

Input: arr1 = [1, 2, 4, 6, 10], arr2 = [4, 5, 6, 9, 12]
Output: 11
Explanation: The merged array looks like [1, 2, 4, 4, 5, 6, 6, 9, 10, 12]. Sum of middle elements is 11 (5 + 6).
Input: arr1 = [1, 12, 15, 26, 38], arr2 = [2, 13, 17, 30, 45]
Output: 32
Explanation: The merged array looks like [1, 2, 12, 13, 15, 17, 26, 30, 38, 45]. Sum of middle elements is 32 (15 + 17).
Expected Time Complexity: O(log n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr1.size() == arr2.size() <= 103
1 <= arr1[i] <= 106
1 <= arr2[i] <= 106

*****************************************************************************************************************************************************


class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
         int n = arr1.length;
        int low=0,high=n-1,mid=0;
        while(low<=high){
            mid = (low+high)/2;
            int midSecond = n-mid-1;
            int first1 = mid>0?arr1[mid-1]:Integer.MIN_VALUE;
            int second1 = arr1[mid];
            int first2 = midSecond>0?arr2[midSecond-1]:Integer.MIN_VALUE;
            int second2 = arr2[midSecond];
            int third1 = mid+1<n?arr1[mid+1]:Integer.MAX_VALUE;
            int third2 = midSecond+1<n?arr2[midSecond+1]:Integer.MAX_VALUE;
            int mx = Math.max(second1,second2);
            if(mx<=third1 && mx<=third2){
                return mx+Math.max(Math.max(first1,first2),Math.min(second1,second2));
            }
            else if(mx>third1){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return 0;
    }
}
    
}
