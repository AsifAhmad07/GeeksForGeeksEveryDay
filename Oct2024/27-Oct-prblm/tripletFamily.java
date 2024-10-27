package 27-Oct-prblm;

public class tripletFamily {


    Name Of The Problem :- Triplet Family

    POTD :- 27-October-2024

    Given an array arr of integers. Find whether three numbers are such that the sum of two elements equals the third element.

Example:

Input: arr[] = [1, 2, 3, 4, 5]
Output: true
Explanation: The pair (1, 2) sums to 3.
Input: arr[] = [5, 3, 4]
Output: false
Explanation: No triplets satisfy the condition.
Expected Time Complexity: O(n2)
Expected Auxilary Space: O(1)

Constraints:
1 <= arr.size() <= 103
0 <= arr[i] <= 105

*****************************************************************************************************************************************************


class Solution {
    public boolean findTriplet(int[] arr) {
        
         int n = arr.length;
        if(n<3)return false;
        Arrays.sort(arr);
        for(int i=n-1;i>=2;i--){
            int j=i-1,k=0;
            while(k<j){
                int sum = arr[k]+arr[j];
                if(sum==arr[i])return true;
                else if(sum<arr[i])k++;
                else j--;
            }
        }
        return false;
    }
}
    
}
