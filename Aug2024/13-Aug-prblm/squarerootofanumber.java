package 13-Aug-prblm;

public class squarerootofanumber {


    Name Of The Problem :- Square root of a number


    POTD :- 13-August-2024

    Given an integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number

Examples:

Input: n = 5
Output: 2
Explanation: Since, 5 is not a perfect square, floor of square_root of 5 is 2.
Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 107

*****************************************************************************************************************************************************Auxiliary

class Solution {
    long floorSqrt(long n) {
        // Your code here
         long low=1,high=n,ans=1,mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(mid*mid==n)return mid;
            else if(mid*mid<n){
                low=mid+1;
                ans=mid;
            }
            else high=mid-1;
        }
        return ans;
    }
}

    
}
