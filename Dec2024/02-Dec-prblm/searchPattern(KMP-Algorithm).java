package 02-Dec-prblm;

public class searchPattern(KMP-Algorithm) {


    Name Of The Problem :- Search Pattern (KMP-Algorithm)

    POTD :- 02-December-2024
    Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
Note: Return an empty list in case of no occurrences of pattern.

Examples :

Input: txt = "abcab", pat = "ab"
Output: [0, 3]
Explanation: The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3. 
Input: txt = "abesdu", pat = "edu"
Output: []
Explanation: There's no substring "edu" present in txt.
Input: txt = "aabaacaadaabaaba", pat = "aaba"
Output: [0, 9, 12]
Explanation:

Constraints:
1 ≤ txt.size() ≤ 106
1 ≤ pat.size() < txt.size()
Both the strings consist of lowercase English alphabets.

*****************************************************************************************************************************************************

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        
         ArrayList<Integer> res=new ArrayList();
        int[] lps = new int[pat.length()];
        calculateLPS(pat, lps);
        int j=0, f=0, i=0;
        int N = txt.length();
        while(i<N){
            if(pat.charAt(j)==txt.charAt(i)){
                i++;
                j++;
            }
            if(j==pat.length()){
                f++;
                res.add(i-j);
                j=lps[j-1];
            }
            else if(i<N&& pat.charAt(j)!=txt.charAt(i)){
                if(j!=0){
                    j=lps[j-1];
                }
                else 
                    i=i+1;
            }
        }
        return res;
    }
    void calculateLPS(String pat, int[] lps){
        int N = pat.length();
        int len=0,i=1;
        while(i<N){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else {
                if(len!=0){
                    len=lps[len-1];
                }
                else {
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
}
    
}
