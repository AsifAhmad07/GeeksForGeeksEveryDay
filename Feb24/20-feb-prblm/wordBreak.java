package 20-feb-prblm;

public class wordBreak {

    Name Of The Problem :- Word Break

    POTD :- 20-feb-2024


    Given a string s and a dictionary of n words dictionary, find out if a s can be segmented into a space-separated sequence of dictionary words. Return 1 if it is possible to break the s into a sequence of dictionary words, else return 0. 

Note: From the dictionary dictionary each word can be taken any number of times and in any order.

Example 1:

Input:
n = 6
s = "ilike"
dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
Output:
1
Explanation:
The string can be segmented as "i like".
Example 2:

Input:
n = 6
s = "ilikesamsung"
dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
Output:
1
Explanation:
The string can be segmented as 
"i like samsung" or "i like sam sung".
Your Task:
Complete wordBreak() function which takes a string and list of strings as a parameter and returns 1 if it is possible to break words, else return 0. You don't need to read any input or print any output, it is done by driver code.

Expected Time Complexity: O(len(s)2)
Expected Space Complexity: O(len(s))

Constraints:
1 ≤ n ≤ 12
1 ≤ len(s) ≤ 1100


-----------------------------------------------------------------------------------------------------------------------------------------------------




class Solution
{
    
     static boolean help(String A,ArrayList<String> B,int index){
        if(index==A.length())return true;
        String temp="";
        boolean a=false;
        for(int i=index;i<A.length();i++){
            temp+=A.charAt(i);
            if(B.contains(temp)==true){
                a = a|help(A,B,i+1);
            }
        }
        return a;
    }
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        //code here
        boolean ans = help(s,dictionary,0);
        return ans==true?1:0;
    }
}
    
}
