package 10-jan-prblm;

public class longestSubArrayDivByK {
    /*
     * Name Of The Problem :- Longest subarray with sum divisible by K
     * POTD - 10 -jan - 2024
     * Given an array arr containing N integers and a positive integer K, find the length of the longest sub array with sum of the elements divisible by the given value K.

Example 1:

Input:
N = 6, K = 3
arr[] = {2, 7, 6, 1, 4, 5}
Output: 
4
Explanation:
The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
Example 2:

Input:
N = 7, K = 3
arr[] = {-2, 2, -5, 12, -11, -1, 7}
Output: 
5
Explanation:
The subarray is {2,-5,12,-11,-1} with sum -3, which is divisible by 3.
Your Task:
The input is already taken care of by the driver code. You only need to complete the function longSubarrWthSumDivByK() that takes an array arr, sizeOfArray n and a  positive integer K, and returns the length of the longest subarray which has sum divisible by K. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= K <= 109
-109 <= A[i] <= 109 
     */
    class Solution{
        int longSubarrWthSumDivByK(int a[], int n, int k)
        {
            // Complete the function
            int ans = 0;
            HashMap<Integer, Integer>map = new HashMap<>();
            int sum = 0;
            int rem = 0;
            map.put(0, -1);
            for(int i = 0; i < n; i++){
                sum += a[i];
                rem = sum % k;
                
                if(rem < 0){
                    rem += k;
                }
                if(map.containsKey(rem)){
                    int idx = map.get(rem);
                    int len = i - idx;
                    if(len > ans){
                        ans = len;
                    }
                }
                else{
                    map.put(rem , i);
                }
            }
            return ans;
           
        }
     
    }
    
    
}
