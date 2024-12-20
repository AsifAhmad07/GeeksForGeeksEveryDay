package 20-Dec-prblm;

public class spirallytraversingamatrix {

    Name Of The Problem :- Spirally traversing a matrix


    POTD :- 20-December-2024

    You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.

Examples:

Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
Explanation: 

Input: mat[][] = [[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14, 15, 16, 17, 18]]
Output: [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
Explanation: Applying same technique as shown above.
Input: mat[][] = [[32, 44, 27, 23], [54, 28, 50, 62]]
Output: [32, 44, 27, 23, 62, 50, 28, 54]
Explanation: Applying same technique as shown above, output will be [32, 44, 27, 23, 62, 50, 28, 54].
Constraints:
1 <= n, m <= 1000
0 <= mat[i][j]<= 100

*****************************************************************************************************************************************************


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        
         int r = mat.length, c = mat[0].length;
        int top = 0, down = r-1, left = 0, right = c-1, d=0;
        ArrayList<Integer> res = new ArrayList();
        while(top<=down && left<=right){
            switch(d){
                case 0:
                    for(int i=left;i<=right;i++){
                        res.add(mat[top][i]);
                    }
                    top++;
                    break;
                case 1:
                    for(int i=top;i<=down;i++){
                        res.add(mat[i][right]);
                    }
                    right--;
                    break;
                case 2:
                    for(int i=right;i>=left;i--){
                        res.add(mat[down][i]);
                    }
                    down--;
                    break;
                case 3:
                    for(int i=down;i>=top;i--){
                        res.add(mat[i][left]);
                    }
                    left++;
                    break;
            }
            if(d==3)
                d=0;
            else 
                d++;
        }
        return res;
    }
}
    
}
