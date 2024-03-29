package 03-jan-prblm;

public class smallestwindow {
    public static void main(String[] args) {
        /*
         * Name Of The Problem :- Smallest window containing 0, 1 and 
         * POTD  - 03-jan-2024
         * LinkOfTheProblem -https://www.geeksforgeeks.org/problems/smallest-window-containing-0-1-and-2--170637/1
         * Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

Example 1:

Input:
S = 01212
Output:
3
Explanation:
The substring 012 is the smallest substring
that contains the characters 0, 1 and 2.
Example 2:

Input: 
S = 12121
Output:
-1
Explanation: 
As the character 0 is not present in the
string S, therefor no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
Your Task:
Complete the function smallestSubstring() which takes the string S as input, and returns the length of the smallest substring of string S that contains all the three characters 0, 1 and 2.

Expected Time Complexity: O( length( S ) )
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ length( S ) ≤ 105
All the characters of String S lies in the set {'0', '1', '2'}
         */
        class Solution {
            public int smallestSubstring(String S) {
                // Code here
                 int zero=-1,one=-1,two=-1,res = 100001;
                
                for(int i=0; i<S.length(); i++){
                    if(S.charAt(i)=='0') zero=i;
                    if(S.charAt(i)=='1') one=i;
                    if(S.charAt(i)=='2') two =i;
                    
                    if(zero==-1 || one==-1 || two==-1) continue;
                    int min = Math.min(Math.min(one,zero),two);
                    int max = Math.max(Math.max(one,zero),two);
                    res = Math.min(res,max-min+1);
        
                }
                return res==100001?-1:res;
            }
        };
    }
    // final commit
}
