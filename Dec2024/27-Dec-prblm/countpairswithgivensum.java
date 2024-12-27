package 27-Dec-prblm;

public class countpairswithgivensum {


    Name Of The Problem :- Count pairs with given sum

    POTD :- 27-December-2024

    Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

Examples:

Input: arr[] = [1, 5, 7, -1, 5], target = 6 
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 
Input: arr[] = [1, 1, 1, 1], target = 2 
Output: 6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
Input: arr[] = [10, 12, 10, 15, -1], target = 125
Output: 0
Constraints:
1 <= arr.size() <= 105
-104 <= arr[i] <= 104
1 <= target <= 104

*****************************************************************************************************************************************************

class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        
         int ans=0;
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int x:arr){
            if(mm.get(target-x)!=null)ans+=mm.get(target-x);
            mm.put(x,mm.getOrDefault(x,0)+1);
        }
        return ans;
    }
}
    
}