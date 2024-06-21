package 21-june-prblm;

public class Comparetwofractions {

    Name Of The Problem :- Compare two fractions

    POTD :- 21-June-2024

    You are given a string str containing two fractions a/b and c/d, compare them and return the greater. If they are equal, then return "equal".

Note: The string str contains "a/b, c/d"(fractions are separated by comma(,) & space( )). 

Examples

Input: str = "5/6, 11/45"
Output: 5/6
Explanation: 5/6=0.8333 and 11/45=0.2444, So 5/6 is greater fraction.
Input: str = "8/1, 8/1"
Output: equal
Explanation: We can see that both the fractions are same, so we'll return a string "equal".
Input: str = "10/17, 9/10"
Output: 9/10
Explanation: 10/17 = 0.588 & 9/10 = 0.9, so the greater fraction is "9/10".
Expected Time Complexity: O(len|str|)
Expected Auxiliary Space: O(1)

Constraints:
0<=a,c<=103
1<=b,d<=103

*****************************************************************************************************************************************************Auxiliary



class Solution {

    String compareFrac(String str) {
        // Code here
         double first=0.0,second=0.0;
        int a=0,b=0;
        boolean indication=false;
        String temp1="",temp2="";
        for(int i=0;i<str.length();i++){
            char x=str.charAt(i);
            if(x=='/'){
                indication=true;
                temp2+=x;
                continue;
            }
            else if(x==','){
                indication=false;
                first=(double)a/b;
                a=0;
                b=0;
                temp1=temp2;
                temp2="";
                continue;
            }
            else if(x==' ')continue;
            temp2+=x;
            if(!indication){
                a=a*10+(x-'0');
            }
            else{
                b=b*10+(x-'0');
            }
        }
        second=(double)a/b;
        if(first>second)return temp1;
        else if(second>first)return temp2;
        return "equal";
    }
}

    
}
