package 31-jul-prblm;

public class longestCommonPrefixofStrings {


    Name Of The Problem :- Longest Common Prefix of Strings


    POTD :- 31-July-2024

    Given an array of strings arr. Return the longest common prefix among all strings present in the array. If there's no prefix common in all the strings, return "-1".

Examples :

Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: gee
Explanation: "gee" is the longest common prefix in all the given strings.
Input: arr[] = ["hello", "world"]
Output: -1
Explanation: There's no common prefix in the given strings.
Expected Time Complexity: O(n*min(|arri|))
Expected Space Complexity: O(min(|arri|))

Constraints:
1 ≤ |arr| ≤ 103
1 ≤ |arr[i]| ≤ 103

*****************************************************************************************************************************************************


class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String temp = arr[0];
        int i=0,j=0;
        while(i<temp.length()){
            for(j=0;j<arr.length;j++){
                if(temp.charAt(i)!=arr[j].charAt(i))break;
            }
            if(j!=arr.length)break;
            i++;
        }
        if(i==0)return "-1";
        return temp.substring(0,i);
    }
}
    
}
