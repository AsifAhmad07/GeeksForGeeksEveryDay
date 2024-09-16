package 16-Sept-prblm;

public class longestvalidParentheses {


    Name Of The problem :- Longest valid Parentheses

    POTd :- 16-September-2024

    Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
Opening parenthesis must be closed in the correct order.
Examples :

Input: str = ((()
Output: 2
Explaination: The longest valid parenthesis substring is "()".
Input: str = )()())
Output: 4
Explaination: The longest valid parenthesis substring is "()()".
Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |str| ≤ 105  

*****************************************************************************************************************************************************   
class Solution{
    static int maxLength(String S){
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
