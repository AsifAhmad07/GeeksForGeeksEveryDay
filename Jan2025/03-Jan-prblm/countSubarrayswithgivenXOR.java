package 03-Jan-prblm;

public class countSubarrayswithgivenXOR {

    Name Of The Problem :- Count Subarrays with given XOR


    POTD :- 03-January-2025

    Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
Constraints:

1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤105
0 ≤ k ≤ 105


*****************************************************************************************************************************************************


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
         int xor_=0,ans=0;
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int x:arr){
            xor_^=x;
            if(xor_==k)ans++;
            ans+=mm.getOrDefault(xor_^k,0);
            mm.put(xor_,mm.getOrDefault(xor_,0)+1);
        }
        return ans;
    }
}
    
}
