package 16-Nov-prblm;

public class moveAllZeroestoEnd {


    Name Of The Problem :- Move All Zeroes to End


    POTD :- 16-Novemeber-2024

    Given an array arr[]. Push all the zeros of the given array to the right end of the array while maintaining the order of non-zero elements. Do the mentioned change in the array in place.

Examples:

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.
Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: No change in array as there are no 0s.
Input: arr[] = [0, 0]
Output: [0, 0]
Explanation: No change in array as there are all 0s.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105

*****************************************************************************************************************************************************

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
         int j=0,n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j++]=temp;
            }
        }
    }
}
    
}
