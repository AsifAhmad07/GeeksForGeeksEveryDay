package 15-Nov-prblm;

public class secondLargest {


    Name Of The Problem :- Second Largest

    POTD :- 15-Novemeber-2024


    Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.

Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.
Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist.
Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

*****************************************************************************************************************************************************

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
         int mx1=Integer.MIN_VALUE,mx2=Integer.MIN_VALUE;
        for(int x:arr){
            if(x>mx1){
                mx2=mx1;
                mx1=x;
            }
            else if(x>mx2 && x!=mx1)mx2=x;
        }
        return mx2!=Integer.MIN_VALUE?mx2:-1;
    }
}
    
}
