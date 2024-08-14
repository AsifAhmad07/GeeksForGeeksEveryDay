package 14-Aug-prblm;

public class longestCommonSubstring {


    Name Of The Problem :- Longest Common Substring


    POTD :- 14-August-2024

    You are given two strings str1 and str2. Your task is to find the length of the longest common substring among the given strings.

Examples:

Input: str1 = "ABCDGH", str2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" which has length 4.
Input: str1 = "ABC", str2 = "ACB"
Output: 1
Explanation: The longest common substrings are "A", "B", "C" all having length 1.
Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).

Constraints:
1<= str1.size(), str2.size()<=1000
Both strings may contain upper and lower case alphabets.

*****************************************************************************************************************************************************

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
         int res = 0;
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (res < dp[i][j]) res = dp[i][j];
                }
            }
        }
        return res;
    }
}
    
}
