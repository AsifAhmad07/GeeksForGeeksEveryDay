package 07-Sept-prblm;

public class nthNaturalNumber {


    Name Of The Problem :- Nth Natural Number

    POTD :- 07-September-2024

    Given a positive integer n. You have to find nth natural number after removing all the numbers containing the digit 9.

Examples :

Input: n = 8
Output: 8
Explanation: After removing natural numbers which contains digit 9, first 8 numbers are 1,2,3,4,5,6,7,8 and 8th number is 8.
Input: n = 9
Output: 10
Explanation: After removing natural numbers which contains digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10 and 9th number is 10.
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 109

*****************************************************************************************************************************************************
class Solution {
    long findNth(long N) {
        // code here
        long result = 0;
        long multiplier = 1;

        while (N > 0) {
            result += (N % 9) * multiplier; // Add the current base 9 digit to result
            N /= 9; // Reduce N
            multiplier *= 10; // Move to the next decimal place
        }

        return result;
    }
}

    
}
