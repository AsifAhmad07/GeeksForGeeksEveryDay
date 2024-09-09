package 09-Sept-prblm;

public class sort0s {


    Name Of The Problem :- Sort 0s, 1s and 2s

POTD :- 09-September-2024

Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.

Examples:

Input: arr[]= [0, 2, 1, 2, 0]
Output: 0 0 1 2 2
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 0]
Output: 0 0 1
Explanation: 0s 1s and 2s are segregated into ascending order.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2

*****************************************************************************************************************************************************

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int n = arr.size(), zero = 0, two = n-1, i = 0;
        while(i<=two){
            if(arr.get(i)==0){
                int temp = arr.get(i);
                arr.set(i,arr.get(zero));
                arr.set(zero,temp);
                zero++;
            }
            else if(arr.get(i)==2){
                int temp = arr.get(i);
                arr.set(i,arr.get(two));
                arr.set(two,temp);
                two--;
                i--;
            }
            i++;
        }
    }
}
    
}
