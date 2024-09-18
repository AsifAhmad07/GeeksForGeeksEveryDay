package 18-Sept-prblm;

public class parenthesisChecker {


    Name Of The Problem :- Parenthesis Checker

    POTD :- 18-September-2024


    Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.
For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).

Note: The driver code prints "balanced" if function return true, otherwise it prints "not balanced".

Examples :

Input: {([])}
Output: true
Explanation: { ( [ ] ) }. Same colored brackets can form balanced pairs, with 0 number of unbalanced bracket.
Input: ()
Output: true
Explanation: (). Same bracket can form balanced pairs,and here only 1 type of bracket is present and in balanced way.
Input: ([]
Output: false
Explanation: ([]. Here square bracket is balanced but the small bracket is not balanced and Hence , the output will be unbalanced.
Expected Time Complexity: O(|x|)
Expected Auixilliary Space: O(|x|)

Constraints:
1 ≤ |x| ≤ 105

*****************************************************************************************************************************************************

class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
         Map<Character,Character> mm = new HashMap<>();
        mm.put(')','(');
        mm.put(']','[');
        mm.put('}','{');
        Stack<Character> st = new Stack<>();
        for(int i=0;i<x.length();i++){
            char c = x.charAt(i);
            if(c=='(' || c=='[' || c=='{')st.push(c);
            else if(st.empty())return false;
            else{
                if(st.peek()!=mm.get(c))return false;
                st.pop();
            }
        }
        return st.empty();
    }
}

    
}
