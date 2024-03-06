package 06-march-prblm;

public class searchPattern {


    Name Of The Problem :- Search Pattern (Rabin-Karp Algorithm)


    POTD :- 06-march-2024


    Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1. The strings will only contain lowercase English alphabets ('a' to 'z').

Example 1:

Input: 
text = "birthdayboy"
pattern = "birth"
Output: 
[1]
Explanation: 
The string "birth" occurs at index 1 in text.
Example 2:

Input:
text = "geeksforgeeks"
pattern = "geek"
Output: 
[1, 9]
Explanation: 
The string "geek" occurs twice in text, one starts are index 1 and the other at index 9.
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string text and the string pattern as input and returns an array denoting the start indices (1-based) of substring pattern in the string text. 

Expected Time Complexity: O(|text| + |pattern|).
Expected Auxiliary Space: O(1).

Constraints:
1<=|text|<=5*105
1<=|pattern|<=|text|



-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
         ArrayList<Integer> res = new ArrayList<>();
        int q = 101;
        int d = 26;
        int M = pat.length();
        int N = txt.length();
        int p = 0;
        int t = 0;
        int h = 1;

        // Calculate h
        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over the text one by one
        for (int i = 0; i <= N - M; i++) {
            // Check the hash if they are equal
            if (p == t) {
                // Check for characters one by one
                int j = 0;
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {
                    res.add(i + 1);
                }
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return res;
    }
}
    
}
