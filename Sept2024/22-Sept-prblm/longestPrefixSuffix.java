package 22-Sept-prblm;

public class longestPrefixSuffix {


    Name Of The Problem :- Longest Prefix Suffix


    POTD :- 22-September-2024

    Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.

Examples :

Input: str = "abab"
Output: 2
Explanation: "ab" is the longest proper prefix and suffix. 
Input: str = "aaaa"
Output: 3
Explanation: "aaa" is the longest proper prefix and suffix. 
Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |str| ≤ 106
str contains lower case English alphabets


*****************************************************************************************************************************************************

class Solution {
    int lps(String str) {
        // code here
         int i=1,j=0,n=str.length();
        int storeLength[] = new int[n];
        while(i<n){
            if(str.charAt(i)==str.charAt(j))storeLength[i++]=++j;
            else{
                if(j>0)j=storeLength[j-1];
                else i++;
            }
        }
        return storeLength[n-1];
    }
}
    
}
