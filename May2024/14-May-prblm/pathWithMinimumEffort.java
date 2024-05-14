package 14-May-prblm;

public class pathWithMinimumEffort {



    Name Of The Problem :- Path With Minimum Effort


    POTD :- 14-May-2024

    You are a hiker preparing for an upcoming hike. You are given heights[][], a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find the route with minimum effort.

Note: A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Example 1:

Input:
row = 3
columns = 3 
heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 
2
Explaination: 
The route 1->3->5->3->5 has a maximum absolute difference of 2 in consecutive cells. This is better than the route 1->2->2->2->5, where the maximum absolute difference is 3.
Example 2:

Input:
row = 2
columns = 2 
heights = [[7,7],[7,7]]
Output: 
0
Explaination: 
Any route from the top-left cell to the bottom-right cell has a maximum absolute difference of 0 in consecutive cells.
Your Task:
You don't need to read input or print anything. Your task is to complete the function MinimumEffort() which takes intergers rows, columns, and the 2D array heights[][]  and returns the minimum effort required to travel from the top-left cell to the bottom-right cell.

Expected Time Complexity: O(rowsxcolumns)
Expected Space Complexity: O(rowsxcolumns)

Constraints:
1 <= rows, columns <= 100
rows == heights.length
columns == heights[i].length
0 <= heights[i][j] <= 106

*****************************************************************************************************************************************************Complexity


class Solution {
    
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // {x, y, effort}
        boolean[][] visited = new boolean[rows][columns];
        
          pq.offer(new int[]{0, 0, 0}); 
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int effort = current[2];
            
             if (x == rows - 1 && y == columns - 1) {
                return effort;
            }
              visited[x][y] = true;
           for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];   
                if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && !visited[nx][ny]) {
                      int diff = Math.abs(heights[x][y] - heights[nx][ny]);
                       int maxDiff = Math.max(diff, effort);
                       
                         pq.offer(new int[]{nx, ny, maxDiff});
                }
           }
        }
          return -1; 
    }
}
    
}
