package 17-Sept-prblm;

public class minimizetheHeightsII {


    Name Of The problem :- Minimize the Heights II

    POTD :- 17-September-2024

    Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

Examples :

Input: k = 2, arr[] = {1, 5, 8, 10}
Output: 5
Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
Input: k = 3, arr[] = {3, 9, 12, 16, 20}
Output: 11
Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11. 
Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(n)

Constraints
1 ≤ k ≤ 107
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 107

*****************************************************************************************************************************************************

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here\
         int n = arr.length;
        if(n==1)return 0;
        Arrays.sort(arr);
        int ans=arr[n-1]-arr[0],mn=0,mx=0;
        for(int i=1;i<n;i++){
            if(arr[i]-k<0)continue;
            mn = Math.min(arr[0]+k,arr[i]-k);
            mx = Math.max(arr[n-1]-k,arr[i-1]+k);
            ans = Math.min(ans,mx-mn);
        }
        return ans;
    }
}

    
}
