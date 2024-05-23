package 23-May-prblm;

public class k-Palindrome {


    Name Of The Problem :- K-Palindrome


    POTD :- 23-May-2024

    Given a string str of length n, find if the string is K-Palindrome or not. A k-palindrome string transforms into a palindrome on removing at most k characters from it.


Example 1:

Input: str = "abcdecba"
n = 8, k = 1
Output: 1
Explaination: By removing 'd' or 'e' 
we can make it a palindrome.

Example 2:

Input: str = "abcdefcba"
n = 9, k = 1
Output: 0
Explaination: By removing a single 
character we cannot make it a palindrome.

Your Task:
You do not need to read input or print anything. Your task is to complete the function kPalindrome() which takes string str, n, and k as input parameters and returns 1 if str is a K-palindrome else returns 0.


Expected Time Complexity: O(n*n)
Expected Auxiliary Space: O(n*n)


Constraints:
1 ≤ n, k ≤ 103

    *************************************************************************************************************************************************



    class Solution {
        public int kPalindrome(String str, int n, int k) {
            // code here
            int dp[][] = new int[n][n];
            for(int i=2;i<=n;i++){
                for(int row=0;row<=n-i;row++){
                    int col=row+i-1;
                    if(str.charAt(row)==str.charAt(col))dp[row][col]=dp[row+1][col-1];
                    else dp[row][col]=Math.min(dp[row][col-1],dp[row+1][col])+1;
                }
            }
            return dp[0][n-1]<=k?1:0;
        }
    }
    
}
