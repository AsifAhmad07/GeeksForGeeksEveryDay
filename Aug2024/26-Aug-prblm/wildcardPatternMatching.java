package 26-Aug-prblm;

public class wildcardPatternMatching {


    Name Of The Problem :- Wildcard Pattern Matching

    POTD :- 26-August-2024

    Given two strings pattern and str which may be of different size, You have to return 1 if the wildcard pattern i.e. pattern, matches with str else return 0. All characters of the string str and pattern always belong to the Alphanumeric characters.

The wildcard pattern can include the characters ? and *
‘?’ – matches any single character.
‘*’ – Matches any sequence of characters (including the empty sequence).

Note: The matching should cover the entire str (not partial str).

Examples:

Input: pattern = "ba*a?", str = "baaabab"
Output: 1
Explanation: replace '*' with "aab" and 
'?' with 'b'.
Input: pattern = "a*ab", str = "baaabab"
Output: 0
Explanation: Because in string pattern character 'a' at first position,
pattern and str can't be matched. 
Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 <= length of(str, pattern) <= 200

*****************************************************************************************************************************************************


class Solution {
    int help(String pattern,String str,int i,int j,int dp[][]){
       if(i==pattern.length() && j==str.length())return 1;
       if(i==pattern.length())return 0;
       if(j==str.length() && pattern.charAt(i)=='*')return help(pattern,str,i+1,j,dp);
       if(j==str.length())return 0;
       if(pattern.charAt(i)!='?' && pattern.charAt(i)!='*' && pattern.charAt(i)!=str.charAt(j))return 0;
       if(dp[i][j]!=-1)return dp[i][j];
       int a=0,b=0,c=0;
       if(pattern.charAt(i)=='*'){
           a=help(pattern,str,i,j+1,dp);
           b=help(pattern,str,i+1,j,dp);
       }
       c=help(pattern,str,i+1,j+1,dp);
       return dp[i][j] = a|b|c;
   }
   public int wildCard(String pattern, String str) {
       // Your code goes here
        int dp[][] = new int[pattern.length()][str.length()];
       for(int temp[]:dp)Arrays.fill(temp,-1);
       return help(pattern,str,0,0,dp);
   }
}

    
}
