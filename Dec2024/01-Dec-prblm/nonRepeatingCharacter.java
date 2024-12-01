package 01-Dec-2024;

public class nonRepeatingCharacter {

    
    Name Of The Problem :- Non Repeating Character

    POTD :- 01-December-2024

    Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating.
Constraints:
1 <= s.size() <= 105

*****************************************************************************************************************************************************


class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String S) {
        // Your code here
         HashMap<Character,Integer> mm = new HashMap<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            mm.putIfAbsent(c,0);
            mm.put(c,mm.get(c)+1);
        }
        for(int i=0;i<S.length();i++){
            if(mm.get(S.charAt(i))==1)return S.charAt(i);
        }
        return '$';
    }
}

}