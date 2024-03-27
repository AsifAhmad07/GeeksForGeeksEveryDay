package 27-march-prblm;

public class findShortestSafeRouteInAMatrix {


    Name Of The Problem :- Find shortest safe route in a matrix



    POTD :- 27-march-2024


    Given a matrix mat[][] with r rows and c columns, where some cells are landmines (marked as 0) and others are safe to traverse. Your task is to find the shortest safe route from any cell in the leftmost column to any cell in the rightmost column of the mat. You cannot move diagonally, and you must avoid both the landmines and their adjacent cells (up, down, left, right), as they are also unsafe.

Example 1:

Input:
mat = [1, 0, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 0, 1],
      [1, 1, 1, 1, 0]
Output: 
6
Explanation: 
We can see that length of shortest
safe route is 6
[1 0 1 1 1]
[1 1 1 1 1]
[1 1 1 1 1]
[1 1 1 0 1] 
[1 1 1 1 0]
Example 2:

Input:
mat = [1, 1, 1, 1, 1],
      [1, 1, 0, 1, 1],
      [1, 1, 1, 1, 1]
Output: 
-1
Explanation: There is no possible path from
first column to last column.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findShortestPath() which takes the matrix as an input parameter and returns an integer denoting the shortest safe path from any cell in the leftmost column to any cell in the rightmost column of mat. If there is no possible path, return -1. 

Expected Time Complexity: O(r * c)
Expected Auxiliary Space: O(r * c)

Constraints:
1 <= r, c <= 103
0 <= mat[][] <= 1

-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public static int findShortestPath(int[][] mat) {
        // code here
        
          int r = mat.length, c = mat[0].length;
       int arr[][] = new int[r][c];
       for(int x[]:arr)Arrays.fill(x,1);
       int direRow[]={-1,0,1,0};
       int direCol[]={0,-1,0,1};
       for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
               if(mat[i][j]==0){
                   arr[i][j]=0;
                   for(int k=0;k<4;k++){
                       int nr = direRow[k]+i;
                       int nc = direCol[k]+j;
                       if(nr>=0 && nr<r && nc>=0 && nc<c){
                           arr[nr][nc]=0;
                       }
                   }
               }
           }
       }
       Queue<int[]> q = new LinkedList<>();
       int vis[][] = new int[r][c];
       for(int x[]:vis)Arrays.fill(x,0);
       for(int i=0;i<r;i++){
           if(arr[i][0]==1)q.add(new int[]{1,i,0});
       }
       while(!q.isEmpty()){
           int[] temp = q.poll();
           int i = temp[1];
           int j = temp[2];
           int dis = temp[0];
           vis[i][j]=1;
           if(j==c-1)return dis;
           for(int k=0;k<4;k++){
               int nr = direRow[k]+i;
               int nc = direCol[k]+j;
               if(nr>=0 && nr<r && nc>=0 && nc<c && vis[nr][nc]==0 && arr[nr][nc]==1){
                   q.add(new int[]{dis+1,nr,nc});
               }
           }
       }
       return -1;
    }
}

    
}
