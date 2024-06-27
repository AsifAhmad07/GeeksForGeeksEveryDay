package 27-june-prblm;

public class toeplitzmatrix {



    Name Of The Problem :- Toeplitz matrix


    POTD :- 27-June-2024


    A Toeplitz (or diagonal-constant) matrix is a matrix in which each descending diagonal from left to right is constant, i.e., all elements in a diagonal are the same. Given a rectangular matrix mat, your task is to complete the function isToeplitz which returns true if the matrix is Toeplitz otherwise, it returns false.

Examples:

Input:
mat = [[6, 7, 8],
       [4, 6, 7],
       [1, 4, 6]]
Output: true
Explanation: The test case represents a 3x3 matrix
 6 7 8 
 4 6 7 
 1 4 6
Output will be true, as values in all downward diagonals from left to right contain the same elements.
Input: 
mat = [[1,2,3],
       [4,5,6]]
Output: false
Explanation: Matrix of order 2x3 will be 1 2 3 4 5 6 Output: false as values in all diagonals are not the same.
Constraints:
1<=mat.size,mat[0].size<=40
0<=mat[i][j]<=100

Expected time complexity: O(n*m)
Expected space complexity: O(1)

*****************************************************************************************************************************************************



class Solution {
    /*You are required to complete this method*/
    boolean isToeplitz(int mat[][]) {
        // Your code here
         Map<Integer, Set<Integer>> mp = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                if (!mp.containsKey(key)) {
                    mp.put(key, new HashSet<>());
                }
                mp.get(key).add(mat[i][j]);
            }
        }
        
        for (Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
            if (entry.getValue().size() > 1) {
                return false;
            }
        }
        
        return true;
    }
}
    
}
