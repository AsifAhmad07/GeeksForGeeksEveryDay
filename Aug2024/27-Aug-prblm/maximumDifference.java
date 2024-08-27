package 27-Aug-prblm;

public class maximumDifference {


    Name Of The Problem :- Maximum Difference


    POTD :- 27-August-2024

    Given an integer array arr of integers, the task is to find the maximum absolute difference between the nearest left smaller element and the nearest right smaller element of every element in array arr. If for any component of the arr, the nearest smaller element doesn't exist then consider it as 0.

Examples :

Input: arr = [2, 1, 8]
Output: 1
Explanation: left smaller array ls = [0, 0, 1], right smaller array rs = [1, 0, 0]. Maximum Diff of abs(ls[i] - rs[i]) = 1
Input: arr = [2, 4, 8, 7, 7, 9, 3]
Output: 4
Explanation: left smaller array ls = [0, 2, 4, 4, 4, 7, 2], right smaller rs = [0, 3, 7, 3, 3, 3, 0]. Maximum Diff of abs(ls[i] - rs[i]) = abs(7 - 3) = 4
Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1 <= arr.size() <= 106
1<= arr[i] <=109

*****************************************************************************************************************************************************


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
         int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.empty() && st.peek()>=arr[i])st.pop();
            if(!st.empty())left[i]=st.peek();
            else left[i]=0;
            st.push(arr[i]);
        }
        while(!st.empty())st.pop();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && st.peek()>=arr[i])st.pop();
            if(!st.empty())right[i]=st.peek();
            else right[i]=0;
            st.push(arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,Math.abs(left[i]-right[i]));
        }
        return ans;
    }
}

    
}
