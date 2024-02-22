package 22-feb-prblm;

public class distictOccurances {


    Name Of The Problem :-  Distinct occurrences


    POTD :- 22-feb-2024


    Given two strings s and t of length n and m respectively. Find the count of distinct occurrences of t in s as a sub-sequence modulo 109 + 7.

Example 1:

Input:
s = "banana" , t = "ban"
Output: 
3
Explanation: 
There are 3 sub-sequences:[ban], [ba n], [b an].
Example 2:

Input:
s = "geeksforgeeks" , t = "ge"
Output: 
6
Explanation: 
There are 6 sub-sequences:[ge], [ge], [g e], [g e] [g e] and [g e].
Your Task:
You don't need to read input or print anything.Your task is to complete the function subsequenceCount() which takes two strings as argument s and t and returns the count of the sub-sequences modulo 109 + 7.

Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).

Constraints:
1 ≤ n,m ≤ 1000

-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution
{
    
    
    static int mod = 1000000007;
    int  subsequenceCount(String s, String t)
    {
	// Your code here	
	
	  int n = s.length();
      int m = t.length();
      int dp[][] = new int[n][m];
      for(int temp[]:dp)Arrays.fill(temp,-1);
      return help(s,t,0,0,dp);
    }
    
     static int help(String s,String t,int i,int j,int dp[][]){
        if(j==t.length())return 1;
        if(i==s.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int a =0,b=0;
        if(s.charAt(i)==t.charAt(j)){
            a = help(s,t,i+1,j+1,dp);
        }
        b = help(s,t,i+1,j,dp);
        return dp[i][j] = (a+b)%mod;
    }
}
    
}
