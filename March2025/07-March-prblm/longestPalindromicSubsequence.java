package 07-March-prblm;

public class longestPalindromicSubsequence {


    name Of The Problem :- Longest Palindromic Subsequence


    POTD :- 07-March-2025

    Given a string s, return the length of the longest palindromic subsequence.

A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

A palindromic sequence is a sequence that reads the same forward and backward.

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.
Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.
Constraints:
1 ≤ s.size() ≤ 1000
The string contains only lowercase letters.



*****************************************************************************************************************************************************

class Solution {
    int dp[][];
    public int f1(String s, String t, int i, int j){
        if(i<0 || j<0)return 0;
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1+f1(s, t, i-1, j-1);
        }
        
        if(dp[i][j] != -1)return dp[i][j];
        
        int first = f1(s, t, i-1, j);
        int second = f1(s, t, i, j-1);
        return dp[i][j] = Math.max(first, second);
    }
    
    public int longestPalinSubseq(String s) {
        // code here
        int n = s.length();
        dp = new int[n][n];
        for(int ar[]: dp){
            Arrays.fill(ar, -1);
        }
        StringBuilder sb = new StringBuilder(s);
        String r = sb.reverse().toString();
        return f1(s, r, n-1, n-1);
    }
}
    
}
