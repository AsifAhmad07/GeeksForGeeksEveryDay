package 02-Sept-prblm;

public class minimumCostPath {


    Name Of The Problem :- Minimum Cost Path

    POTD :- 02-September-2024

    Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  

Examples :

Input: grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
Input: grid = {{4,4},{3,7}}
Output: 14
Explanation: The grid is-
4 4
3 7
The minimum cost is- 4 + 3 + 7 = 14.
Expected Time Complexity: O(n2*log(n))
Expected Auxiliary Space: O(n2) 
 Constraints:
1 ≤ n ≤ 500
1 ≤ cost of cells ≤ 500


*****************************************************************************************************************************************************


class Solution {
    class Cell implements Comparable<Cell> {
        int x, y, distance;

        Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Cell other) {
            if (this.distance == other.distance) {
                if (this.x != other.x)
                    return this.x - other.x;
                return this.y - other.y;
            }
            return this.distance - other.distance;
        }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        TreeSet<Cell> st = new TreeSet<>();
        st.add(new Cell(0, 0, 0));
        dp[0][0] = grid[0][0];

        while (!st.isEmpty()) {
            Cell cur = st.pollFirst();
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (isValid(x, y, n, m) && dp[x][y] > dp[cur.x][cur.y] + grid[x][y]) {
                    if (dp[x][y] != Integer.MAX_VALUE)
                        st.remove(new Cell(x, y, dp[x][y]));
                    dp[x][y] = dp[cur.x][cur.y] + grid[x][y];
                    st.add(new Cell(x, y, dp[x][y]));
                }
            }
        }
        return dp[n-1][m-1];
    }
}
    
}
