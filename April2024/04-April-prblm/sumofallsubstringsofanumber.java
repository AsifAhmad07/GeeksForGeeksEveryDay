package 04-April-prblm;

public class sumofallsubstringsofanumber {


    Name Of The Problem :- Sum of all substrings of a number

    POTD :- 04-April-2024

    Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.
As the answer will be large, return answer modulo 109+7. 

Note: The number may have leading zeros.

Example 1:

Input:
s = "1234"
Output: 
1670
Explanation: 
Sum = 1 + 2 + 3 + 4 + 12 + 23 + 34 + 123 + 234 + 1234 = 1670
Example 2:

Input:
s = "421"
Output: 
491
Explanation: 
Sum = 4 + 2 + 1 + 42 + 21 + 421 = 491
Your Task:
You only need to complete the function sumSubstrings that takes s as an argument and returns the answer modulo 109+7.

Expected Time Complexity: O(|s|).
Expected Auxiliary Space: O(|s|).

Constraints:
1 <= |s| <= 105

-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    
    long ans=0,previous=0,mod=1000000007;
        for(int i=0;i<s.length();i++){
            long curr = (previous*10)%mod+(s.charAt(i)-'0')*(i+1)%mod;
            previous=curr;
            ans=(ans+curr)%mod;
        }
        return ans;
    }
}

    
}
