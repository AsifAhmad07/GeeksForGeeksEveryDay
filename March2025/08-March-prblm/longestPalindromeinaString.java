package 08-March-prblm;

public class longestPalindromeinaString {


    Name Of The Problem :- Longest Palindrome in a String


    POTD :- 08-March-2025

    Given a string s, your task is to find the longest palindromic substring within s.

A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.

Examples :

Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.
Input: s = “Geeks” 
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks". 
Input: s = “abc” 
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned.
Constraints:
1 ≤ s.size() ≤ 103
s consist of only lowercase English letters.


*****************************************************************************************************************************************************

class Solution {
    static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String longestPalin = "";
        for (int i = 0; i < s.length(); i++) {
            String pal1 = expandAroundCenter(s, i, i);
            if (pal1.length() > longestPalin.length()) {
                longestPalin = pal1;
            }
            String pal2 = expandAroundCenter(s, i, i + 1);
            if (pal2.length() > longestPalin.length()) {
                longestPalin = pal2;
            }
        }

        return longestPalin;
    }
}
    
}
