package 22-Oct-prblm;

public class sub-arrayswithequalnumberofoccurences {

    Name Of The Problem :- Sub-arrays with equal number of occurences


    POTD :- 22-October-2024

    Given an array arr[] and two integers say, x and y, find the number of sub-arrays in which the number of occurrences of x is equal to the number of occurrences of y.

Examples:

Input: arr[] = [1, 2, 1] , x= 1 , y = 2
Output: 2
Explanation: The possible sub-arrays have same equal number of occurrences of x and y are:
1) [1, 2], x and y have same occurrence(1).
2) [2, 1], x and y have same occurrence(1).
Input: arr[] = [1, 2, 1] , x = 4 , y = 6
Output: 6
Explanation: The possible sub-arrays have same equal number of occurrences of x and y are:
1) [1], x and y have same occurrence(0).
2) [2], x and y have same occurrence(0).
3) [1], x and y have same occurrence(0).
4) [1, 2], x and y have same occurrence(0).
5) [2, 1], x and y have same occurrence(0).
6) [1, 2, 1], x and y have same occurrence(0).
Input: arr[] = [1, 2, 1] , x= 1 , y = 4
Output: 1
Explanation: The possible sub-array have same equal number of occurrences of x and y is: [2], x and y have same occurrence(0)
Constraints: 
1 <= arr.size() <= 106
1 <= arr[i], x, y<=106

*****************************************************************************************************************************************************


class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        
         int n = arr.length;
        int[] countX = new int[n];
        int[] countY = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                countX[i] = (i != 0) ? countX[i - 1] + 1 : 1;
            } else {
                countX[i] = (i != 0) ? countX[i - 1] : 0;
            }
            
            if (arr[i] == y) {
                countY[i] = (i != 0) ? countY[i - 1] + 1 : 1;
            } else {
                countY[i] = (i != 0) ? countY[i - 1] : 0;
            }
            
            map.put(countX[i] - countY[i], map.getOrDefault(countX[i] - countY[i], 0) + 1);
        }

        int result = map.getOrDefault(0, 0);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long freq = entry.getValue();
            result += (freq * (freq - 1)) / 2;
        }
        
        return result;
    }
}
    
}
