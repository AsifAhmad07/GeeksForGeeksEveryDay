package 24-Sept-prblm;

public class smallestwindowinastringcontainingallthecharactersofanotherstring {



    Name Of The Problem :- Smallest window in a string containing all the characters of another string

    POTD :- 24-September-2024

    Given two strings s and p. Find the smallest window in the string s consisting of all the characters(including duplicates) of the string p.  Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index.
Note : All characters are in Lowercase alphabets. 

Examples:

Input: s = "timetopractice", p = "toc"
Output: toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.
Input: s = "zoomlazapzo", p = "oza"
Output: apzo
Explanation: "apzo" is the smallest 
substring in which "oza" can be found.
Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(n), n = len(p)

Constraints: 
1 ≤ |s|, |p| ≤ 105


*****************************************************************************************************************************************************

class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
         if(p.length()>s.length())return "-1";
        int forS[] = new int[26];
        int forP[] = new int[26];
        int c=0,c2=0,n=s.length(),m=p.length(),j=0,start=-1,end=-1,len=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            char x = p.charAt(i);
            forP[x-'a']++;
            if(forP[x-'a']==1)c++;
        }
        for(int i=0;i<n;i++){
            char x = s.charAt(i);
            forS[x-'a']++;
            if(forS[x-'a']==forP[x-'a'])c2++;
            if(c2==c){
                while(forS[s.charAt(j)-'a']>forP[s.charAt(j)-'a'])forS[s.charAt(j++)-'a']--;
                if(len>i-j+1){
                    start=j;
                    end=i;
                    len=i-j+1;
                }
            }
        }
        if(start==-1)return "-1";
        return s.substring(start,end+1);
    }
}
    
}
