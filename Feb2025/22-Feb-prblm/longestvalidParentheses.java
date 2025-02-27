package 22-Feb-prblm;

public class longestvalidParentheses {


    Name Of The Problem :- Longest valid Parentheses


    POTD :- 22-February-2025

    Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
The closing parenthesis must be after its opening parenthesis.
Examples :

Input: s = "((()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".
Input: s = ")()())"
Output: 4
Explanation: The longest valid parenthesis substring is "()()".
Input: s = "())()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".
Constraints:
1 ≤ s.size() ≤ 106  
s consists of '(' and ')' only

*****************************************************************************************************************************************************


class Solution {
    static int maxLength(String S) {
        // code here
         int mx = 0, op = 0, cl = 0, mx2 = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(')op++;
            else cl++;
            if(cl>op){
                op=0;
                cl=0;
            }
            else if(op==cl)mx=Math.max(mx,op*2);
        }
        op=0;
        cl=0;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i)=='(')op++;
            else cl++;
            if(op>cl){
                op=0;
                cl=0;
            }
            else if(op==cl)mx2=Math.max(mx2,op*2);
        }
        return Math.max(mx,mx2);
    }
}
    
}
