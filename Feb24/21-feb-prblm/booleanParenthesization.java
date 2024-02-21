package 21-feb-prblm;

public class booleanParenthesization {



    Nme Of The Problem :- Boolean Parenthesization

    POTD :- 21-feb-2024



    Given a boolean expression s of length n with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Note: The answer can be large, so return it with modulo 1003

Example 1:

Input: 
n = 7
s = T|T&F^T
Output: 
4
Explaination: 
The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Example 2:

Input: 
n = 5
s = T^F|F
Output: 
2
Explaination: 
((T^F)|F) and (T^(F|F)) are the only ways.
Your Task:
You do not need to read input or print anything. Your task is to complete the function countWays() which takes n and s as input parameters and returns number of possible ways modulo 1003.

Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)

Constraints:
1 ≤ n ≤ 200 




-----------------------------------------------------------------------------------------------------------------------------------------------------



class Solution{
    static int[][][] dp;
    
    static int countWays(int n, String s){
        dp = new int[n][n][2];
        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, -1);
            }
        }
         return solve(s, 0, n - 1, 1) % 1003;
    }
     static int solve(String str, int i, int j, int isTrue) {
        if (i > j) return 0;
        if (i == j) return (str.charAt(i) == (isTrue == 1 ? 'T' : 'F')) ? 1 : 0;
         if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int temp_ans = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            int lt = solve(str, i, k - 1, 1);
            int lf = solve(str, i, k - 1, 0);
            int rt = solve(str, k + 1, j, 1);
            int rf = solve(str, k + 1, j, 0);

            if (str.charAt(k) == '&') {
                temp_ans += (isTrue == 1) ? (lt * rt) : (lt * rf + lf * rt + lf * rf);
            } else if (str.charAt(k) == '|') {
                temp_ans += (isTrue == 1) ? (lt * rt + lt * rf + lf * rt) : (lf * rf);
            } else if (str.charAt(k) == '^') {
                temp_ans += (isTrue == 1) ? (lt * rf + lf * rt) : (lt * rt + lf * rf);
            }
        }

        return dp[i][j][isTrue] = temp_ans % 1003;
    }
}
    
}
