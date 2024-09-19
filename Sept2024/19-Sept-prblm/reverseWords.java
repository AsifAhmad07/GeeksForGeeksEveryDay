package 19-Sept-prblm;

public class reverseWords {


    Name Of The Problem :- Reverse Words

    POTD :- 19-September-2024


    Given a String str, reverse the string without reversing its individual words. Words are separated by dots.

Note: The last character has not been '.'. 

Examples :

Input: str = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i
Input: str = pqr.mno
Output: mno.pqr
Explanation: After reversing the whole string , the input string becomes mno.pqr
Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 <= |str| <= 105


*****************************************************************************************************************************************************

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
         StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='.'){
                temp.reverse();
                temp.append('.');
                ans.append(temp);
                temp=new StringBuilder();
            }
            else if(i==str.length()-1){
                temp.append(str.charAt(i));
                temp.reverse();
                ans.append(temp);
            }
            else temp.append(str.charAt(i));
        }
        ans.reverse();
        return ans.toString();
    }
}
    
}
