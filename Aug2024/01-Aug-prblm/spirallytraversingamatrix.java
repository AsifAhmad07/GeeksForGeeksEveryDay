import java.util.ArrayList;

package 01-Aug-prblm;

public class spirallytraversingamatrix {


    Name Of The Problem :- Spirally traversing a matrix


    POTD :- 01-August-2024

    You are given a rectangular matrix, and your task is to return an array while traversing the matrix in spiral form.

Examples:

Input: matrix[][] = [[1, 2, 3, 4],
                  [5, 6, 7, 8],
                  [9, 10, 11, 12],
                  [13, 14, 15,16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
Explanation:

Input: matrix[][] = [[1, 2, 3, 4],
                  [5, 6, 7, 8],
                  [9, 10, 11, 12]]
Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
Explanation: Applying same technique as shown above, output for the 2nd testcase will be 1 2 3 4 8 12 11 10 9 5 6 7.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 <= matrix.size(), matrix[0].size() <= 100
0 <= matrix[i][j]<= 100


*****************************************************************************************************************************************************



class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
         int n=matrix.length,m=matrix[0].length,s=n*m;
        ArrayList<Integer> ans = new ArrayList<>();
        // a -> row start, b -> col start, c-> row end, d-> col end
        int a=0,b=0,c=n-1,d=m-1;
        while(ans.size()<s){
            for(int i=b;i<=d && ans.size()<s;i++)ans.add(matrix[a][i]);
            a++;
            for(int i=a;i<=c && ans.size()<s;i++)ans.add(matrix[i][d]);
            d--;
            for(int i=d;i>=b && ans.size()<s;i--)ans.add(matrix[c][i]);
            c--;
            for(int i=c;i>=a && ans.size()<s;i--)ans.add(matrix[i][b]);
            b++;
        }
        return ans;
    }
}


    
}