package 30-Oct-prblm;

public class pairswithdifferencek {

    Name Of The Problem :- Pairs with difference k


    POTD :- 30-October-2024

    Given an array arr[] of positive integers. Find the number of pairs of integers whose difference equals a given number k.
Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices are considered different.

Examples:

Input: arr[] = [1, 5, 3, 4, 2], k = 3
Output: 2
Explanation: There are 2 pairs with difference 3,the pairs are {1, 4} and {5, 2} 
Input: arr[] = [8, 12, 16, 4, 0, 20], k = 4
Output: 5
Explanation: There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}.
Constraints:
1 <= arr.size() <= 106
1 <= k <= 106
0 <= arr[i] <= 106


*****************************************************************************************************************************************************

class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        // code here
        
          int ans = 0;
        Map<Integer,Integer> mm = new HashMap<>();
        for(int x:arr)mm.put(x,mm.getOrDefault(x,0)+1);
        for(int x:arr)ans+=mm.getOrDefault(x+k,0);
        return ans;
    }
}
    
}
