package 04-Jan-prblm;

public class countalltripletswithgivensuminsortedarray {


    Name Of The Problem :- Count all triplets with given sum in sorted array

    POTD :- 04-January-2025

    Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1. 
Constraints:
3 ≤ arr.size() ≤ 103
-105 ≤ arr[i], target ≤ 105


*****************************************************************************************************************************************************


class Solution {
    public int countTriplets(int[] arr, int k) {
        // Code Here
        
         int n = arr.length;
        int ans=0;
        for(int i=0; i<n; i++){
            int l=i+1; int h=n-1; 
            while(l<h){
                int sum = arr[i]+ arr[l] + arr[h];
                if(sum==k){
                    int t1=arr[l], c1=0, t2=arr[h], c2=0;
                    while(l<=h && arr[l]==t1){
                        l++; c1++;
                    }
                     while(l<=h && arr[h]==t2){
                        h--; c2++;
                    }
                    ans +=  (t1==t2) ? (c1*(c1-1))/2 : c1*c2 ;
                }
                else if(sum > k)
                h--;
                
                else{
                    l++;
                }
            }
        }
        return ans;
    }
}
    
}
