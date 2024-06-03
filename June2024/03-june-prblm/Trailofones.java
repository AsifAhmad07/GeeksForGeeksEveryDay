package 03-june-prblm;

public class Trailofones {


    Name Of The Problem :- Trail of ones

    POTD :- 03-June-2024

    Given a number n, find the number of binary strings of length n that contain consecutive 1's in them. Since the number can be very large, return the answer after modulo with 1e9+7.

Example 1:

Input: n = 2
Output: 1
Explanation: There are 4 strings of length 2, the strings are 00, 01, 10, and 11. Only the string 11 has consecutive 1's.
Example 2:

Input: n = 5
Output: 19
Explanation: There are 19 strings having consecutive 1's.
Your Task:

You don't need to read input or print anything. Your task is to complete the function numberOfConsecutiveOnes() which takes an integer n and returns the number of binary strings that contain consecutive 1's in them.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints
2 <= n <= 105

*****************************************************************************************************************************************************Auxiliary

class Solution {
    static int numberOfConsecutiveOnes(int n) {
        // code here
         if(n==2)return 1;
        int ans=1,a=0,b=1,mod=1000000007;
        for(int i=3;i<=n;i++){
            int c=(a+b)%mod;
            a=b;
            b=c;
            ans=((ans*2)%mod+c)%mod;
        }
        return ans;
    }
}

    
}
