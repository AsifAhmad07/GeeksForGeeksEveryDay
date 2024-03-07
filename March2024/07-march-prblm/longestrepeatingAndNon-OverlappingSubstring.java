package 07-march-prblm;

public class longestrepeatingAndNon-OverlappingSubstring {


    Name Of The Problem :- Longest repeating and non-overlapping substring
    POTD :- 07-march-2024
    

    Given a string s of length n, find the longest repeating non-overlapping substring in it. In other words find 2 identical substrings of maximum length which do not overlap. Return the longest non-overlapping substring. Return "-1" if no such string exists.

Note: Multiple Answers are possible but you have to return the substring whose first occurrence is earlier.

For Example: "abhihiab", here both "ab" and "hi" are possible answers. But you will have to return "ab" because it's first occurrence appears before the first occurrence of "hi".

Example 1:

Input:
n = 9
s = "acdcdacdc"
Output:
"acdc"
Explanation:
The string "acdc" is the longest Substring of s which is repeating but not overlapping.
Example 2:

Input:
n = 7
s = "heheheh"
Output:
"heh"
Explanation:
The string "heh" is the longest Substring of s which is repeating but not overlapping.
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestSubstring() which takes an Integer n and a string s as input and returns the answer.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 <= n <= 103

-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution {
    static String longestSubstring(String s, int N) {
        // code here
        
         int[][] LCS = new int[N + 1][N + 1];
    
        int res_length = 0; 
        int idx = 0; 
     
      
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) &&
                    LCS[i - 1][j - 1] +1 <= (j - i)) {  //no overlapping
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
     
                    if (LCS[i][j] > res_length) { // do not update for equal, need 1st occurence
                        res_length = LCS[i][j];
                        idx = i-1;
                    }
                } 
            }
        }
     
        StringBuilder res = new StringBuilder(); // To store result
        if (res_length > 0) {
            for (int i = idx - res_length + 1; i <= idx; i++) {
                res.append(s.charAt(i));
            }
        } 
        else 
            res.append("-1");
        
        return res.toString();
    }
};
}
