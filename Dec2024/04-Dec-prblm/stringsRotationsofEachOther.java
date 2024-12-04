package 04-Dec-prblm;

public class stringsRotationsofEachOther {


    Name Of The Problem :- Strings Rotations of Each Other


    POTD :- 04-December-2024

    You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

Note: The characters in the strings are in lowercase.

Examples :

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.
Constraints:
1 <= s1.size(), s2.size() <= 105

*****************************************************************************************************************************************************

class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
         StringBuilder temp = new StringBuilder(s2);
        temp.append('$').append(s1).append(s1);
        int n = temp.length(),i=0,j=1,m=s2.length();
        int lps[] = new int[n];
        Arrays.fill(lps,0);
        String str = temp.toString();
        while(j<n){
            if(str.charAt(i)==str.charAt(j)){
                lps[j++]=++i;
                if(i==m)return true;
            }
            else if(i!=0)i=lps[i-1];
            else j++;
        }
        return false;
    }
}
    
}
