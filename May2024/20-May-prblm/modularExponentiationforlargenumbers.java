package 20-May-prblm;

public class modularExponentiationforlargenumbers {


    Name Of The Problem :- Modular Exponentiation for large numbers


    POTD :- 20-May-2024

    Implement pow(x, n) % M.
In other words, for a given value of x, n, and M, find  (xn) % M.
 

Example 1:

Input:
x = 3, n = 2, m = 4
Output:
1
Explanation:
32 = 9. 9 % 4 = 1.
Example 2:

Input:
x = 2, n = 6, m = 10
Output:
4
Explanation:
26 = 64. 64 % 10 = 4.

Your Task:
You don't need to read or print anything. Your task is to complete the function PowMod() which takes integers x, n, and M as input parameters and returns xn % M.
 

Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)
 

Constraints:
1 ≤ x, n, M ≤ 109


*****************************************************************************************************************************************************Complexity


class Solution
{
    public long PowMod(long x, long n, long m)
    {
        // Code here
         long ans =1;
	    while(n>0){
	        if(n%2==1)ans=(ans*x)%m;
	        x=(x*x)%m;
	        n/=2;
	    }
	    return ans;
    }
}
    
}
