package 26-Dec-prblm;

public class twoSumPairwithGivenSum {


    Name Of The Problem :- Two Sum - Pair with Given Sum

    POTD :- 26-December-2024

    Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.

Examples:

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16.
Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11.
Constraints:
1 ≤ arr.size ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤ target ≤ 2*105

*****************************************************************************************************************************************************

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
         HashMap<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int ans = arr[i];
            if(map.containsKey(target - ans)){
                return true;
            }
            map.put(arr[i], i);
            
        }
        return false;
    }
}
    
}
