package 15-Oct-prblm;

public class subarrayrangewithgivensum {


    Name Of The Problem :- Subarray range with given sum

    POTD :- 15-October-2024

    Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value.

Examples:

Input: arr[] = [10, 2, -2, -20, 10] , tar = -10
Output: 3
Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
Input: arr[] = [1, 4, 20, 3, 10, 5] , tar = 33
Output: 1
Explanation: Subarray with sum 33 is: [20,3,10].
Expected Time Complexity: O(n)
Expected Auxilary Space: O(n)

Constraints:
1 <= arr.size() <= 106
-105 <= arr[i] <= 105
-105 <= tar <= 105


*****************************************************************************************************************************************************

class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // add your code here
        Map<Integer,Integer> mm = new HashMap<>();
        int ans=0,sum=0;
        for(int x:arr){
            sum+=x;
            if(sum==tar)ans++;
            if(mm.get(sum-tar)!=null)ans+=mm.get(sum-tar);
            mm.put(sum,mm.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
    
}
