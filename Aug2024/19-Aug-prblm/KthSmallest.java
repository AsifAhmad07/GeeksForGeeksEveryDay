package 19-Aug-prblm;

public class KthSmallest {

    Name Of The Problem :- Kth Smallest

    POTD :- 19-August-2024

    Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array. It is given that all array elements are distinct.

Follow up: Don't solve it using the inbuilt sort function.

Examples :

Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
Output:  7
Explanation: 3rd smallest element in the given array is 7.
Input: arr[] = [7, 10, 4, 20, 15], k = 4 
Output:  15
Explanation: 4th smallest element in the given array is 15.
Expected Time Complexity: O(n+(max_element) )
Expected Auxiliary Space: O(max_element)
Constraints:
1 <= arr.size <= 106
1<= arr[i] <= 106
1 <= k <= n

*****************************************************************************************************************************************************



class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int mx = Integer.MIN_VALUE;
        for(int x:arr)mx=Math.max(x,mx);
        int hash[] = new int[mx+1];
        Arrays.fill(hash,0);
        for(int x:arr)hash[x]=1;
        for(int i=1;i<=mx;i++){
            k-=hash[i];
            if(k==0)return i;
        }
        return 0;
    }
}

    
}
