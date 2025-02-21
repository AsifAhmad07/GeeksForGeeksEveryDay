package 21-Feb-prblm;

public class parenthesisChecker {


    Name Of The Problem :- Parenthesis Checker

    POTD :- 21-February-2025

    Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
    An input string is valid if:
    
             1. Open brackets must be closed by the same type of brackets.
             2. Open brackets must be closed in the correct order.
    
    Examples :
    
    Input: s = "[{()}]"
    Output: true
    Explanation: All the brackets are well-formed.
    Input: s = "[()()]{}"
    Output: true
    Explanation: All the brackets are well-formed.
    Input: s = "([]"
    Output: False
    Explanation: The expression is not balanced as there is a missing ')' at the end.
    Input: s = "([{]})"
    Output: False
    Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
    Constraints:
    1 ≤ s.size() ≤ 106
    s[i] ∈ {'{', '}', '(', ')', '[', ']'}
    
*****************************************************************************************************************************************************

class Solution {
    static boolean isBalanced(String A) {
        // code here
        
           Stack<Character>st = new Stack();
        for(int i = 0; i < A.length();i++){
            char ch = A.charAt(i);
            if(st.size() == 0){
                st.push(ch);
            }
            else if((ch == '}' && st.peek() == '{') || (ch == ']' && st.peek() == '[') || (ch == ')' && st.peek() == '(')){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        if(st.size() > 0){
            return false;
        }
        else
        return true;
    }
}

    
}
