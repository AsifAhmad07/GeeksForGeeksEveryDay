package 11-jul-prblm;

public class maximumConnectedgroup {


    Name Of The problem :- Maximum Connected group

    POTD :- 11-July-2024

    You are given a square binary grid. A grid is considered binary if every value in the grid is either 1 or 0. You can change at most one cell in the grid from 0 to 1. You need to find the largest group of connected  1's. Two cells are said to be connected if both are adjacent(top, bottom, left, right) to each other and both have the same value.

Examples :

Input: grid = [1, 1]
             [0, 1]
Output: 4
Explanation: By changing cell (2,1), we can obtain a connected group of 4 1's
[1, 1]
[1, 1]
Input: grid = [1, 0, 1]
             [1, 0, 1]
             [1, 0, 1]
Output: 7
Explanation: By changing cell (3,2), we can obtain a connected group of 7 1's
[1, 0, 1]
[1, 0, 1]
[1, 1, 1]
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 <= size of the grid<= 500
0 <= grid[i][j] <= 1



*****************************************************************************************************************************************************



class Solution {

    public int MaxConnection(int grid[][]) {
        // Your code here
         int n=grid.length;
        //part 1
        Map<Integer,Integer> compToCount = new HashMap<>();
        
        int id = 2;
        for(int i=0; i<n; i++)
        for(int j=0; j<n; j++){
            if(grid[i][j] != 1) continue;
            
            int count = dfs(grid, i, j, id);//give same id to all the cells of same component
            compToCount.put(id, count);//store count of cells corresponding to that id
            id++;
        }
        
        //part 2
        int maxCnt = grid[0][0]==0 ? 1 : compToCount.get(grid[0][0]);//edge case when all cells are 1
        
        Set<Integer> set = new HashSet<>(4);//adjacent cells may belong to same id(i.e same component)
        
        for(int i=0; i<n; i++)
        for(int j=0; j<n; j++){
            if(grid[i][j] != 0) continue;
            int cnt = 1;
            
            for(int[] dir : directions){
                int r = dir[0]+i, c = dir[1]+j;
                if(checkBounds(r, c, n) && grid[r][c]!=0 && set.add(grid[r][c]))
                    cnt+= compToCount.get(grid[r][c]);
            }
            
            if(cnt > maxCnt) maxCnt = cnt;
            set.clear();
        }    
        
        return maxCnt;
    }
    
    private static int dfs(int[][] grid, int i, int j, int id){
        grid[i][j] = id;
        
        int cnt = 1;
        for(int[] dir : directions){
            int r = dir[0]+i, c = dir[1]+j;
            
            if(checkBounds(r, c, grid.length) && grid[r][c]==1){
                cnt+= dfs(grid, r, c, id);
            }
        }
        
        return cnt;
    }
    
    private static int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    private static boolean checkBounds(int i, int j, int n){
        return i>=0 && i<n && j>=0 && j<n;
    }
}
    
}
