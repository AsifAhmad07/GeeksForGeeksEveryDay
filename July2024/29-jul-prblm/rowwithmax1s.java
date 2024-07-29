package 29-jul-prblm;

public class rowwithmax1s {



    Name Of The Problem ;- Row with max 1s

    POTD :- 29-July-2024

    Given a boolean 2D array, consisting of only 1's and 0's, where each row is sorted. Return the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.

Examples:

Input: arr[][] = [[0, 1, 1, 1],
               [0, 0, 1, 1],
               [1, 1, 1, 1],
               [0, 0, 0, 0]]
Output: 2
Explanation: Row 2 contains 4 1's (0-based indexing).
Input: arr[][] = [[0, 0], 
               [1, 1]]
Output: 1
Explanation: Row 1 contains 2 1's (0-based indexing).
Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ number of rows, number of columns ≤ 103
0 ≤ arr[i][j] ≤ 1 

*****************************************************************************************************************************************************

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
          int i=0,j=arr[0].length-1,ans=-1;
        while(i<arr.length && j>=0){
            if(arr[i][j]==0){
                i++;
            }
            else{
                ans=i;
                j--;
            }
        }
        return ans;
    }
}
    
}
