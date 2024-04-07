package 07-April-prblm;

public class maximizedotproduct {


    Name Of The Problem :- Maximize dot product

    POTD :- 07-April-2024

    Given two arrays a and b of positive integers of size n and m where n >= m, the task is to maximize the dot product by inserting zeros in the second array but you cannot disturb the order of elements.

Dot product of array a and b of size n is a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1].

Example 1:

Input: 
n = 5, a[] = {2, 3, 1, 7, 8} 
m = 3, b[] = {3, 6, 7}
Output: 
107
Explanation: 
We get maximum dot product after inserting 0 at first and third positions in second array.
Therefore b becomes {0, 3, 0, 6, 7}. 
Maximum dot product = 2*0 + 3*3 + 1*0 + 7*6 + 8*7 = 107.
Example 2:

Input: 
n = 3, a[] = {1, 2, 3}
m = 1, b[] = {4} 
Output: 
12 
Explanation: 
We get maximum dot product after inserting 0 at first and second positions in second array.
Therefore b becomes {0, 0, 4}. 
Maximum Dot Product = 1*0 + 2*0 + 3*4 = 12.
Your Task:  
You don't need to read input or print anything. Complete the function maxDotProduct() which takes n, m, array a and b as input parameters and returns the maximum value.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ m ≤n ≤ 103
1 ≤ a[i], b[i] ≤ 103


-----------------------------------------------------------------------------------------------------------------------------------------------------


class Solution
{
    
    int help(int i,int j,int n,int m,int a[],int b[],int dp[][],int diff){
	    if(i==n || j==m)return 0;
	    if(dp[i][j]!=-1)return dp[i][j];
	    int sum1=0,sum2=0;
	    if(diff!=0)
	    sum1 = help(i+1,j,n,m,a,b,dp,diff-1);
	    sum2 =a[i]*b[j]+help(i+1,j+1,n,m,a,b,dp,diff);
	    return dp[i][j] = Math.max(sum1,sum2);
	}
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		int dp[][] = new int[n][m];
		for(int temp[]:dp){
		    Arrays.fill(temp,-1);
		}
		return help(0,0,n,m,a,b,dp,n-m);
	} 
}



    
}
