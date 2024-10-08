package 08-Oct-prblm;

public class largestPairSum {


    Name Of The Problem :- Largest Pair Sum


    POTD :- 07-October-2024

    Find the largest pair sum in an array of distinct integers.

Examples :

Input: arr[] = [12, 34, 10, 6, 40]
Output: 74
Explanation: Sum of 34 and 40 is the largest, i.e, 34 + 40 = 74.
Input: arr[] = [10, 20, 30]
Output: 50
Explanation: 20 + 30 = 50.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106

*****************************************************************************************************************************************************


class Solution {
    public static int pairsum(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for(int x:arr){
            if(x>largest){
                secondLargest=largest;
                largest=x;
            }
            else if(x>secondLargest)secondLargest=x;
        }
        return largest+secondLargest;
    }
}

    
}
