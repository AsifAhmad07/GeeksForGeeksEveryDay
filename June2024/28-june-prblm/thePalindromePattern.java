package 28-june-prblm;

public class thePalindromePattern {


    Name Of The Problem :- The Palindrome Pattern

    POTD :- 28-June-2024

    Given a two-dimensional integer array arr of dimensions n x n, consisting solely of zeros and ones, identify the row or column (using 0-based indexing) where all elements form a palindrome. If multiple palindromes are identified, prioritize the palindromes found in rows over those in columns. Within rows or columns, the palindrome with the smaller index takes precedence. The result should be represented by the index followed by either 'R' or 'C', indicating whether the palindrome was located in a row or column. The output should be space-separated. If no palindrome is found, return the string -1.

Examples:

Input: 
arr[][] =  [[1, 0, 0], 
           [0, 1, 0],
           [1, 1, 0]]
Output: 1 R
Explanation: In the first test case, 0-1-0 is a palindrome 
occuring in a row having index 1.
Input: 
arr[][] =   [[1, 0],
           [1, 0]]
Output: 0 C
Explanation: 1-1 occurs before 0-0 in the 0th column. And there is no palindrome in the two rows.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
1<= arr.size <= 50
0 <= arr[i][j] <= 1

*****************************************************************************************************************************************************Auxiliary


// User function Template for Java

class Solution {
    public boolean palindrome(int[] arr, int n) {
       for (int i = 0; i < n / 2; i++) {
           if (arr[i] != arr[n - 1 - i]) {
               return false;
           }
       }
       return true;
   }

   public String pattern(int[][] arr) {
       // Code here
       int n = arr.length;
       String ans = "-1";

       // Check for row
       for (int i = 0; i < n; i++) {
           int[] currRow = new int[n];
           for (int j = 0; j < n; j++) {
               currRow[j] = arr[i][j];
           }

           if (palindrome(currRow, n)) {
               ans = i + " R";
               return ans;
           }
       }

       // Check for column
       for (int j = 0; j < n; j++) {
           int[] currCol = new int[n];
           for (int i = 0; i < n; i++) {
               currCol[i] = arr[i][j];
           }

           if (palindrome(currCol, n)) {
               ans = j + " C";
               return ans;
           }
       }

       return ans;
   }
}

    
}
