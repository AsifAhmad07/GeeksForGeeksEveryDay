package 02-Nov-prblm;

public class kthdistance {



    Name Of The Problem :- Kth distance

    POTD :- 02-Novemeber-2024

    Given an unsorted array arr and a number k which is smaller than the size of the array. Return true if the array contains any duplicate within k distance throughout the array else false.

Examples:

Input: arr[] = [1, 2, 3, 4, 1, 2, 3, 4] and k = 3
Output: false
Explanation: All duplicates are more than k distance away.
Input: arr[] = [1, 2, 3, 1, 4, 5] and k = 3
Output: true
Explanation: 1 is repeated at distance 3.
Input: arr[] = [6, 8, 4, 1, 8, 5, 7] and k = 3
Output: true
Explanation: 8 is repeated at distance 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k < arr.size()
1 ≤ arr[i] ≤ 105

*****************************************************************************************************************************************************


class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
         HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        if (n == 1) return false;

        // Initial window of size k
        for (int i = 0; i <= k && i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > 1) return true;
        }

        // Slide the window
        int last = 0;
        for (int i = k + 1; i < n; i++) {
            map.put(arr[last], map.get(arr[last]) - 1);
            if (map.get(arr[last]) == 0) {
                map.remove(arr[last]);
            }
            last++;
            
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > 1) return true;
        }
        return false;
    }
}
    
}
