package 04-june-prblm;

public class binaryrepresentationofnextnumber {


    Name Of The Problem :- Binary representation of next number

    POTD :- 04-June-2024


    Given a binary representation in the form of a string(s) of a number n, the task is to find a binary representation of n+1.

Example 1:

Input: s = "10"
Output: 11
Explanation: "10" is the binary representation of 2 and binary representation of 3 is "11"
Example 2:

Input: s = "111"
Output: 1000
Explanation: "111" is the binary representation of 7 and binary representation of 8 is "1000"
Your Task:  
You don't need to read input or print anything. Complete the function binaryNextNumber()which takes s as input parameter and returns the string.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n) to store resultant string  

Constraints:
1 <= n <= 105

*****************************************************************************************************************************************************Auxiliary


class Solution {
    String binaryNextNumber(String s) {
        // code here.
         boolean indication=true;
        char[] temp = s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            if(temp[i]=='0'){
                temp[i]='1';
                indication=false;
                break;
            }
            else temp[i]='0';
        }
        StringBuilder ans = new StringBuilder();
        if(indication==true){
            ans.append('1');
            ans.append(temp);
        }
        else{
            int index=0;
            while(index<s.length() && temp[index]=='0')index++;
            ans.append(temp,index,s.length()-index);
        }
        return ans.toString();
    }
}
    
}
