package 07-Aug-prblm;

public class k-thelementoftwoArrays {


    Name Of The Problem :- K-th element of two Arrays


    POTD :- 07-August-2024

    Given two sorted arrays arr1 and arr2 and an element k. The task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
Output: 6
Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10. The 5th element of this array is 6.
Input: k = 7, arr1[] = [100, 112, 256, 349, 770], arr2[] = [72, 86, 113, 119, 265, 445, 892]
Output: 256
Explanation: Combined sorted array is - 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892. 7th element of this array is 256.
Expected Time Complexity: O(log(n) + log(m))
Expected Auxiliary Space: O(log (n))

Constraints:
1 <= k<= arr1.size()+arr2.size()
1 <= arr1.size(), arr2.size() <= 106
0 <= arr1[i], arr2[i] < 108

*****************************************************************************************************************************************************

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
          int n1 = arr1.length, n2 = arr2.length;
        
        if (k == n1 + n2) return Math.max(arr1[n1 - 1], arr2[n2 - 1]);
        if (k == 1) return Math.min(arr1[0], arr2[0]);
        
        int i = 0, j = 0;
        while (i < n1 && j < n2 && k > 1) {
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                j++;
            }
            k--;
        }
        
        while (i < n1 && k > 1) {
            i++;
            k--;
        }
        
        while (j < n2 && k > 1) {
            j++;
            k--;
        }
        
        if (i == n1) return arr2[j];
        else if (j == n2) return arr1[i];
        return Math.min(arr1[i], arr2[j]);
    }
}

    
}
