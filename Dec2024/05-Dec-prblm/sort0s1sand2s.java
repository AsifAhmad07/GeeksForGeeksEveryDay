package 05-Dec-prblm;

public class sort0s1sand2s {


    Name Of The Problem :- Sort 0s, 1s and 2s


    POTD :- 05-December-2024

    Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2


*****************************************************************************************************************************************************

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
          int n = arr.length; // Use length for array size
        int zero = 0, two = n - 1, i = 0;

        while (i <= two) {
            if (arr[i] == 0) {
                // Swap arr[i] and arr[zero]
                int temp = arr[i];
                arr[i] = arr[zero];
                arr[zero] = temp;
                zero++;
                i++;
            } else if (arr[i] == 2) {
                // Swap arr[i] and arr[two]
                int temp = arr[i];
                arr[i] = arr[two];
                arr[two] = temp;
                two--;
            } else {
                i++;
            }
        }
    }
}
    
}
