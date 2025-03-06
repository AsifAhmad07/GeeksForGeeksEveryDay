package 06-March-prblm;

public class longestCommonSubsequence {


    Name Of The Problem :- Longest Common Subsequence

    POTD :- 06-March-2025

    Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.

A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".

Examples:

Input: s1 = "ABCDGH", s2 = "AEDFHR"
Output: 3
Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.
Input: s1 = "ABC", s2 = "AC"
Output: 2
Explanation: The longest common subsequence of "ABC" and "AC" is "AC", which has a length of 2.
Input: s1 = "XYZW", s2 = "XYWZ"
Output: 3
Explanation: The longest common subsequences of "XYZW" and "XYWZ" are "XYZ" and "XYW", both of length 3.
Constraints:
1<= s1.size(), s2.size() <=103
Both strings s1 and s2 contain only uppercase English letters.

*****************************************************************************************************************************************************

class Solution {
    static int lcs(String s1, String s2) {
        // code here
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        int m = s1.length();
        int n= s2.length();
        int memo[][]=new int[m+1] [n+1];
        for(int []row:memo)
        Arrays.fill(row,-1);
        int res= subseq(c1,c2,m,n,memo);
        return res;
    }
    static int subseq(char s1[],char s2[],int m ,int n , int memo[][])
    {
        if(m==0||n==0)
        return memo[m][n]=0;
        if(memo[m][n]!=-1)
        return memo[m][n];
        if(s1[m-1]==s2[n-1])
        memo[m][n]=1+subseq(s1,s2,m-1,n-1,memo);
        else
        memo[m][n]=Math.max(subseq(s1,s2,m,n-1,memo),subseq(s1,s2,m-1,n,memo));
        return memo[m][n];
    }
}
    
}
