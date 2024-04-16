package 16-April-prblm;

public class minimizetheDifference {



    Name Of The Problem :- Minimize the Difference



    Date :- 16-April-2024

    You are given an array arr of size n. You have to remove a subarray of size k , such that the difference between the maximum and minimum values of the remaining array is minimized.
Find the minimum value obtained after performing the operation of the removal of the subarray and return it.

Example 1:

Input:
n = 5
k = 3
arr = {1, 2, 3, 4, 5}
Output: 
1
Explanation: 
We can remove first subarray of length 3(i.e. {1, 2, 3}) then remaining array will be {4,5} and the difference of maximum and minimum element will be 1 i.e 5 - 4 = 1
Example 2:

Input:
n = 6
k = 3
arr = {2, 3, 1, 4, 6, 7}
Output: 
2
Explanation:
If we remove the subarray {2,3,1} then remaining array will be {4,6,7} and the difference  = 7-4 = 3
If we remove the subarray {3,1,4} then remaining array will be {2,6,7} and the difference  = 7-2 = 5
If we remove the subarray {1,4,6} then remaining array will be {2,3,7} and the difference  = 7-2 = 5
If we remove the subarray {4,6,7} then remaining array will be {2,3,1} and the difference  = 3-1 = 2
So the answer will be min(3,5,5,2) = 2
Your Task: 
You have to complete the function minimizeDifference( ), which takes two integers n and k and an integer array arr of size n. You have to return the minimum difference of maximum and minimum elements of the remaining array after removing one k length subarray of it.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
2 <= n <= 105
1 <= k <= n-1
0 <= arr[i] <= 109


-----------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
        int rightmx[]=new int[n];
        int rightmn[]=new int[n];
        rightmx[n-1]=arr[n-1];
        rightmn[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightmn[i]=Math.min(rightmn[i+1],arr[i]);
            rightmx[i]=Math.max(rightmx[i+1],arr[i]);
        }
        int i=0,j=k-1,mn=Integer.MAX_VALUE,mx=Integer.MIN_VALUE,ans=Integer.MAX_VALUE;
        while(j<n){
            if(i!=0){
                mn=Math.min(arr[i-1],mn);
                mx=Math.max(arr[i-1],mx);
            }
            int temp1=mx,temp2=mn;
            if(j!=n-1){
                temp1=Math.max(mx,rightmx[j+1]);
                temp2=Math.min(mn,rightmn[j+1]);
            }
            ans=Math.min(ans,Math.abs(temp1-temp2));
            i++;
            j++;
        }
        return ans;
    }
}
   
    
}
