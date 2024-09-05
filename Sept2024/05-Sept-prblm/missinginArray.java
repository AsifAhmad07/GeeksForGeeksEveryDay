package 05-Sept-prblm;

public class missinginArray {


    Name Of The Problem :- Missing in Array

    POTD :- 05-September-2024

    Given an array arr of size n−1 that contains distinct integers in the range of 1 to n (inclusive), find the missing element. The array is a permutation of size n with one element missing. Return the missing element.

Examples:

Input: n = 5, arr[] = [1,2,3,5]
Output: 4
Explanation : All the numbers from 1 to 5 are present except 4.
Input: n = 2, arr[] = [1]
Output: 2
Explanation : All the numbers from 1 to 2 are present except 2.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ n


*****************************************************************************************************************************************************
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        // Your Code Here
         int val = 0;

        // XOR numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            val = val ^ i;
        }

        // XOR elements of the array
        for (int i = 0; i < arr.length; i++) {
            val = val ^ arr[i];
        }

        return val;
    }
}
    
}
