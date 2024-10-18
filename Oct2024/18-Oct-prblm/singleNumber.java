package 18-Oct-prblm;

public class singleNumber {


    Name Of The Problem :- Single Number


    POTD :- 18-October-2024

    Given an array arr[] of positive integers where every element appears even times except for one. Find that number occurring an odd number of times.

Examples:

Input: arr[] = [1, 1, 2, 2, 2]
Output: 2
Explanation: In the given array all element appear two times except 2 which appears thrice.
Input: arr[] = [8, 8, 7, 7, 6, 6, 1]
Output: 1
Explanation: In the given array all element appear two times except 1 which appears once.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arri ≤ 105



*****************************************************************************************************************************************************

class Solution {
    int getSingle(int arr[]) {
        // code here
         int ans = 0;
        for(int x:arr)ans^=x;
        return ans;
    }
}
    
}
