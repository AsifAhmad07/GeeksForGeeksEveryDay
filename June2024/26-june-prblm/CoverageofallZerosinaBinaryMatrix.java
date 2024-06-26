package 26-june-prblm;

public class CoverageofallZerosinaBinaryMatrix {


    Name Of The Problem :- Coverage of all Zeros in a Binary Matrix


    POTD :- 26-June-2024

    Given a binary matrix contains 0s and 1s only, we need to find the sum of coverage of all zeros of the matrix where coverage for a particular 0 is defined as a total number of ones around a zero in left, right, up and bottom directions.

Examples:

Input:
matrix = [[0, 1, 0],
          [0, 1, 1],
          [0, 0, 0]]
Output: 6
Explanation: There are a total of 6 coverage are there

Input: 
matrix = [[0, 1]]
Output: 1
Explanation: There are only 1 coverage.
Expected Time Complexity: O(n * m)
Expected Space Complexity: O(1)

Constraints:
1 <= matrix.size, matrix[0].size <= 100

*****************************************************************************************************************************************************Space

class Solution {
    public int findCoverage(int[][] mat) {
        // code here
         int cnt = 0;
        int m = mat.length, n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    if (j < n - 1 && mat[i][j + 1] == 1) 
                        ++cnt;
                    if (j > 0 && mat[i][j - 1] == 1) 
                        ++cnt;
                    if (i < m - 1 && mat[i + 1][j] == 1) 
                        ++cnt;
                    if (i > 0 && mat[i - 1][j] == 1) 
                        ++cnt;
                }
            }
        }
        
        return cnt;
    }
}
    
}
