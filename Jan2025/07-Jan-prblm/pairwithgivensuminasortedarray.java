package 07-Jan-prblm;

public class pairwithgivensuminasortedarray {

    Name Of The Problem :- Pair with given sum in a sorted array


    POTD :- 07-January-2025

    You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 2 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 4.
Constraints:
-105 <= target <=105
 2 <= arr.size() <= 105
-105 <= arr[i] <= 105


*****************************************************************************************************************************************************


class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        
         int ans=0, st=0, end=arr.length-1;
        while(st<end){
            int currSum = arr[st]+arr[end];
            if(currSum>target){
                end--;
            }
            else if(currSum<target){
                st++;
            }
            else {
                int e1 = arr[st], e2=arr[end], c1=0, c2=0;
                while(st<=end && arr[st] == e1){
                    st++;
                    c1++;
                }
                while(st<=end && arr[end] == e2){
                    end--;
                    c2++;
                }
                if(e1 == e2){
                    ans+=(c1*(c1-1))/2;
                }
                else {
                    ans+=c1*c2;
                }
            }
        }
        return ans;
    }
}
    
}
